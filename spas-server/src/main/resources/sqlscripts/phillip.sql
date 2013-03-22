select a.num, a.name, count(c.code)
from Student a
inner join fact b on b.student_Num = a.num
inner join subject c on c.code = b.subject_code
where
50 > (
            select ((sum(f.actualmark/100*e.weight) / sum(e.weight)) * 100)
            from assessment e
            inner join mark f on f.assesment_Id = e.id
            where e.subject_code = c.code
            AND f.student_Num = a.num
        )
Group By a.num, a.name