--This function gets a particular student's progress
CREATE OR REPLACE FUNCTION student_subject_progress(fn_student_num VARCHAR,fn_subject_code VARCHAR) RETURNS NUMERIC AS $$
DECLARE v_student_tot DECIMAL;
DECLARE v_normalized_tot DECIMAL;
DECLARE v_normalized_mark DECIMAL;
DECLARE v_weight DECIMAL;
DECLARE v_weight_tot DECIMAL;

DECLARE student_mark_cursor CURSOR FOR
			SELECT  m.actualmark AS m_mark,a.name AS a_name,a.weight AS a_weight,sb.code AS sb_code,s.num AS s_num
			FROM Subject sb,Assessment a,Mark m,Student s
			WHERE sb.code = a.subject_code
			AND a.id = m.assesment_id
			AND m.student_num = s.num
			ORDER BY s.num DESC,a.name; 

DECLARE student_mark_rec RECORD;


BEGIN
	-- initialize the variables
	v_student_tot:= 0;
	v_normalized_tot:=0;
	v_normalized_mark :=0;
	v_weight := 0;
	v_weight_tot := 0;
	
	--open the cursor
	OPEN student_mark_cursor;
	--loop & fetch
	LOOP
		FETCH student_mark_cursor INTO student_mark_rec;
		EXIT WHEN NOT FOUND;
		
		IF student_mark_rec.s_num = fn_student_num AND student_mark_rec.sb_code = fn_subject_code THEN
			
			--normalize student mark to weight
            IF student_mark_rec.m_mark > 0 THEN
                v_normalized_mark := (student_mark_rec.m_mark * student_mark_rec.a_weight)/100;
            END IF;
			
			--add up the normalized marks total 
			v_normalized_tot := v_normalized_tot + v_normalized_mark;
			
			--add up the weight total
			v_weight_tot := v_weight_tot + student_mark_rec.a_weight;
			
		END IF;
		
	END LOOP;
	--close
	CLOSE student_mark_cursor;
	
	--calculate the student subject mark
	v_student_tot := (v_normalized_tot * v_weight_tot)/100;
	RETURN v_student_tot;

END;
$$ LANGUAGE plpgsql



-- Zuko's procedure
--gets the top performing student's by subject
SELECT s.num AS s_num,sb.code,student_subject_progress(s.num,sb.code) AS subject_progress
FROM Student s,Fact f,Subject sb
WHERE s.num = f.student_num
AND f.subject_code = sb.code
AND f.canceldate IS NULL
ORDER BY sb.code ASC,subject_progress DESC;
			
--function gets a student's progress for the course overall
CREATE OR REPLACE FUNCTION student_course_progress(fn_student_num VARCHAR) RETURNS NUMERIC AS $$
	DECLARE v_course_tot NUMERIC;
	DECLARE v_course_avg NUMERIC;
	DECLARE v_subject_count INTEGER;
	
	DECLARE student_cs_cursor CURSOR FOR
		SELECT s.num AS s_num,sb.code,student_subject_progress(s.num,sb.code) AS subject_progress
		FROM Student s,Fact f,Subject sb
		WHERE s.num = f.student_num
		AND f.subject_code = sb.code
		AND f.canceldate IS NULL
		ORDER BY sb.code ASC,subject_progress DESC;
	DECLARE student_cs_rec RECORD;
BEGIN 
	-- initialize the vaeiables
	v_course_tot:=0;
	v_course_avg:=0;
	v_subject_count:=0;
	
	--open the cursor
	OPEN student_cs_cursor;
	
	--loop & fetch cursor
	LOOP
		FETCH student_cs_cursor INTO student_cs_rec;
		EXIT WHEN NOT FOUND;
		
		IF student_cs_rec.s_num = fn_student_num THEN
				v_course_tot:= v_course_tot + student_cs_rec.subject_progress;
				v_subject_count:= v_subject_count + 1;
		END IF;
		
	END LOOP;
	--close cursor
	CLOSE student_cs_cursor;
	
	--calculate the course average
    IF v_course_avg = 0 THEN
        RETURN v_course_avg;
    ELSE
        v_course_avg:=v_course_tot/v_subject_count;
    END IF;
	
	RETURN v_course_avg;
END
$$ LANGUAGE plpgsql

--my stuff
--returns the best performing student by course
CREATE OR REPLACE VIEW vw_best_student_per_course AS 
	SELECT s.num,c.code,MAX(student_course_progress(s.num)) AS high
	FROM Course c,Student s
	WHERE c.code = s.course_code
	GROUP BY c.code, s.num;


 SELECT * FROM vw_best_student_per_course;















	

	
	
	
	
	
