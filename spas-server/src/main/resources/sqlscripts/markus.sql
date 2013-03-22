create or replace function student_single_subject(character) Returns Table (Student_no character, Student_Name character, ClassGroup character, Subject character, Percentage double precision, Weight double precision) AS
'select a.num, a.name, b.classgroup_code, c.name,      --perhaps need to add classgroup description table
 (
            select ((sum((m.actualmark/100) * ass.weight) / sum(ass.weight)) * 100)
            from assessment ass
            inner join mark m on m.assesment_id = ass.ID
            where ass.subject_code = c.code
            AND m.student_Num = a.Num
            and m.actualmark <> -1

) as Percentage,
(select sum(d.weight) from assessment d inner join mark ma on ma.assesment_id = d.id
 where d.subject_code = c.code and ma.student_Num = a.Num
            and ma.actualmark <> -1) as "weight so far"

from Student a
inner join fact b on b.student_num = a.num
inner join subject c on c.code = b.subject_code
where c.code = $1
and (
            select ((sum((m.actualmark/100) * ass.weight) / sum(ass.weight)) * 100)
            from assessment ass
            inner join mark m on m.assesment_id = ass.ID
            where ass.subject_code = c.code
            AND m.student_Num = a.Num
            and m.actualmark <> -1

) < 50'
LANGUAGE 'sql';