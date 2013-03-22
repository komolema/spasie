/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.spas.data.jpa;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;
import com.spas.data.StatisticsDAO;

/**
 *
 * @author yawaco
 */
@Transactional
public class StatisticsDAOJPAImpl implements StatisticsDAO{

    private DataSource ds;
    private JdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource ds) {
        this.ds = ds;
       jdbcTemplate = new JdbcTemplate(this.ds);
       jdbcTemplate.setResultsMapCaseInsensitive(true);        
    }
   
    public List getTopStudentsPerSubject() {
        return this.jdbcTemplate.queryForList("SELECT s.num AS s_num,sb.code,student_subject_progress(s.num,sb.code) " +
                "AS subject_progress " +
                "FROM Student s,Fact f,Subject sb " +
                "WHERE s.num = f.student_num " +
                "AND f.subject_code = sb.code " +
                "ORDER BY sb.code ASC,subject_progress DESC ");
    }

    public List getTopStudentPerCource() {
        return this.jdbcTemplate.queryForList("SELECT s.num AS s_num,sb.code,student_subject_progress(s.num,sb.code) " +
                "AS subject_progress " +
                "FROM Student s,Fact f,Subject sb " +
                "WHERE s.num = f.student_num " +
                "AND f.subject_code = sb.code " +
                "ORDER BY sb.code ASC,subject_progress DESC ");       
    }

    public List getTopStudentPerTest() {
         return this.jdbcTemplate.queryForList("SELECT s.num AS s_num,sb.code,student_subject_progress(s.num,sb.code) " +
                "AS subject_progress " +
                "FROM Student s,Fact f,Subject sb " +
                "WHERE s.num = f.student_num " +
                "AND f.subject_code = sb.code " +
                "ORDER BY sb.code ASC,subject_progress DESC ", new Object[] {});
    }

    public List getStudentInDangerPerSubject() {
        return this.jdbcTemplate.queryForList("select * from student_single_subject('DOS311C')");
    }

    public List getStudentsInDangerOverall() {

        return this.jdbcTemplate.queryForList(
        "select a.num, a.name, count(c.code) " +
                "from Student a " +
                "inner join fact b on b.student_Num = a.num " +
                "inner join subject c on c.code = b.subject_code " +
                " where 50 > ( " +
                " select ((sum(f.actualmark/100*e.weight) / sum(e.weight)) * 100) " +
                " from assessment e " +
                " inner join mark f on f.assesment_Id = e.id " +
                " where e.subject_code = c.code " +
                " AND f.student_Num = a.num )" +
                " Group By a.num, a.name ");
    }

    public void createTopStudentsPerSubject() {
        String sql = "CREATE OR REPLACE FUNCTION student_subject_progress(fn_student_num VARCHAR,fn_subject_code VARCHAR) RETURNS NUMERIC AS $$ " +
                "DECLARE v_student_tot DECIMAL; " +
                "DECLARE v_normalized_tot DECIMAL; " +
                "DECLARE v_normalized_mark DECIMAL; " +
                "DECLARE v_weight DECIMAL; " +
                "DECLARE v_weight_tot DECIMAL; " +
                "DECLARE student_mark_cursor CURSOR FOR " +
                "SELECT  m.actualmark AS m_mark,a.name AS a_name,a.weight AS a_weight,sb.code AS sb_code,s.num AS s_num " +
                "FROM Subject sb,Assessment a,Mark m,Student s " +
                "WHERE sb.code = a.subject_code " +
                "AND a.id = m.assesment_id " +
                "AND m.student_num = s.num " +
                "ORDER BY s.num DESC,a.name; " +
                "DECLARE student_mark_rec RECORD; " +
                "BEGIN " +
                "v_student_tot:= 0; " +
                "v_normalized_tot:=0; " +
                "v_normalized_mark :=0; " +
                "v_weight := 0; " +
                "v_weight_tot := 0; " +
                "OPEN student_mark_cursor; " +
                "LOOP " +
                "FETCH student_mark_cursor INTO student_mark_rec; " +
                "EXIT WHEN NOT FOUND; " +
                "IF student_mark_rec.s_num = fn_student_num AND student_mark_rec.sb_code = fn_subject_code THEN " +
                "IF student_mark_rec.m_mark > 0 THEN " +
                "v_normalized_mark := (student_mark_rec.m_mark * student_mark_rec.a_weight)/100; " +
                "END IF; " +
                "v_normalized_tot := v_normalized_tot + v_normalized_mark; " +
                "v_weight_tot := v_weight_tot + student_mark_rec.a_weight; " +
                "END IF; " +
                "END LOOP; " +
                "CLOSE student_mark_cursor; " +
                "v_student_tot := (v_normalized_tot * v_weight_tot)/100; " +
                "RETURN v_student_tot; " +
                "END; " +
                "$$ LANGUAGE plpgsql ";
        jdbcTemplate.execute(sql);
    }

    public void createTopStudentPerCourse() {
        String sql = "CREATE OR REPLACE FUNCTION student_course_progress(fn_student_num VARCHAR) RETURNS NUMERIC AS $$ " +
                "DECLARE v_course_tot NUMERIC; " +
                "DECLARE v_course_avg NUMERIC; " +
                "DECLARE v_subject_count INTEGER; " +
                "DECLARE student_cs_cursor CURSOR FOR " +
                "SELECT s.num AS s_num,sb.code,student_subject_progress(s.num,sb.code) AS subject_progress " +
                "FROM Student s,Fact f,Subject sb " +
                "WHERE s.num = f.student_num " +
                "AND f.subject_code = sb.code " +
                "AND f.canceldate IS NULL " +
                "ORDER BY sb.code ASC,subject_progress DESC; " +
                "DECLARE student_cs_rec RECORD; " +
                "BEGIN " +
                "v_course_tot:=0; " +
                "v_course_avg:=0; " +
                "v_subject_count:=0; " +
                "OPEN student_cs_cursor; " +
                "LOOP " +
                "FETCH student_cs_cursor INTO student_cs_rec; " +
                "EXIT WHEN NOT FOUND; " +
                "IF student_cs_rec.s_num = fn_student_num THEN " +
                "v_course_tot:= v_course_tot + student_cs_rec.subject_progress; " +
                "v_subject_count:= v_subject_count + 1; " +
                "END IF; " +
                "END LOOP; " +
                "CLOSE student_cs_cursor; " +
                "IF v_course_avg = 0 THEN " +
                "RETURN v_course_avg; " +
                "ELSE " +
                "v_course_avg:=v_course_tot/v_subject_count; " +
                "END IF; " +
                "RETURN v_course_avg; " +
                "END " +
                "$$ LANGUAGE plpgsql";

        jdbcTemplate.execute(sql);
    }

    public void createTopStudentPerTest() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void createStudentInDangerPerSubject() {
        String sql = "create or replace function student_single_subject(character) Returns Table (Student_no character, Student_Name character, ClassGroup character, " +
                "Subject character, Percentage double precision, Weight double precision) AS " +
                "'select a.num, a.name, b.classgroup_code, c.name, " +
                "(select ((sum((m.actualmark/100) * ass.weight) / sum(ass.weight)) * 100) " +
                "from assessment ass " +
                "inner join mark m on m.assesment_id = ass.ID " +
                "where ass.subject_code = c.code " +
                "AND m.student_Num = a.Num " +
                "and m.actualmark <> -1 ) as Percentage, " +
                "(select sum(d.weight) from assessment d inner join mark ma on ma.assesment_id = d.id " +
                "where d.subject_code = c.code and ma.student_Num = a.Num " +
                "and ma.actualmark <> -1) as \"weight so far\" " +
                "from Student a " +
                "inner join fact b on b.student_num = a.num " +
                "inner join subject c on c.code = b.subject_code " +
                "where c.code = $1 " +
                "and ( " +
                "select ((sum((m.actualmark/100) * ass.weight) / sum(ass.weight)) * 100) " +
                "from assessment ass " +
                "inner join mark m on m.assesment_id = ass.ID " +
                "where ass.subject_code = c.code " +
                "AND m.student_Num = a.Num " +
                "and m.actualmark <> -1 " +
                ") < 50' " +
                "LANGUAGE 'sql' ";

        jdbcTemplate.execute(sql);
    }

    public void createStudentsInDangerOverall() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
