-- Zuko's procedure
--gets the top performing student's by subject
SELECT s.num AS s_num,sb.code,student_subject_progress(s.num,sb.code) AS subject_progress
FROM Student s,Fact f,Subject sb
WHERE s.num = f.student_num
AND f.subject_code = sb.code
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
	v_course_avg:=v_course_tot/v_subject_count;

	RETURN v_course_avg;
END
$$ LANGUAGE plpgsql
