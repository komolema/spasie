/*procedure 1.1 for viewing the student with the highest mark in a test*/

create or replace function get_top_student(p_subject text, p_assessment_name text) returns text as $$

declare top_student text;

begin

   select student.name
   into top_student
   from student, subject, assessment, mark
   where assessment.id = mark.assesment_id and
      mark.student_num = student.num and
      assessment.name = p_assessment_name and
      subject.code = p_subject
   order by mark.actualmark desc
   limit 1;

   return top_student;

end;

$$ LANGUAGE plpgsql;

select * from get_top_student('DOS311C', 'T4');

/*procedure 1.2 for viewing the top mark in a test*/

create or replace function top_mark(p_subject text, p_assessment_name text) returns integer as $$
declare

high_mark integer;

begin

   select mark.actualmark
   into high_mark
   from student, subject, assessment, mark
   where assessment.id = mark.assesment_id and
      mark.student_num = student.num and
      assessment.name = p_assessment_name and
      subject.code = p_subject
   order by mark.actualmark desc
   limit 1;


   return high_mark;

end;

$$ LANGUAGE plpgsql;

select * from top_mark('DOS311C','T4');

/*procedure 2.1 for selecting students that passed the test*/
create or replace function passed_students(p_subject text, p_assessment_name text) returns integer as $$
DECLARE  passed integer;

begin

   select count(student.num)
   into passed
   from student, subject, assessment, mark
   where   mark.student_num = student.num and
	   assessment.name = p_assessment_name and
           subject.code = p_subject and
           mark.actualmark >= 50;

   return passed;


end;

$$ LANGUAGE plpgsql;

select * from passed_students('DOS311C','T1');

/*procedure 2.2 for selecting students that passed the test with a distinction*/
create OR REPLACE function distinction_students(p_subject text, p_assessment_name text) returns integer as $$
DECLARE  distinctions integer;

begin

   select count(student.num)
   into distinctions
   from student, subject, assessment, mark
   where   mark.student_num = student.num and
	   assessment.name = p_assessment_name and
           subject.code = p_subject and
           mark.actualmark >= 75;

   return distinctions;


end;

$$ LANGUAGE plpgsql;

select * from distinction_students('DOS311C','T1');






