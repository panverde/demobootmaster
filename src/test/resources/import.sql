INSERT INTO subject(subject_name)VALUES ('CURSOA');
INSERT INTO subject(subject_name)VALUES ('CURSOB');
INSERT INTO subject(subject_name)VALUES ('CURSOD');
INSERT INTO subject(subject_name)VALUES ('CURSOE');
INSERT INTO subject(subject_name)VALUES ('CURSOCLASS1');
INSERT INTO subject(subject_name)VALUES ('CURSOCLASS2');
INSERT INTO subject(subject_name)VALUES ('CURSOCLASS3');
INSERT INTO subject(subject_name)VALUES ('CURSOCLASENEW');
INSERT INTO subject(subject_name)VALUES ('CURSOCLASEUPDATE');
INSERT INTO subject(subject_name)VALUES ('CURSOCLASEDELETE');
INSERT INTO subject(subject_name)VALUES ('CURSOCLASSSTUDENT');
INSERT INTO subject(subject_name)VALUES ('CURSOCLASSSTUDENTLIST');
INSERT INTO subject(subject_name)VALUES ('CURSOCLASSSTUDENTLIST2');

INSERT INTO teacher(first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('TEACHER01', 'M', 'TEACHER01A','TEACHER01A2', 'DESCTEACHER01');
INSERT INTO teacher(first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('TEACHER02', 'M', 'TEACHER02A','TEACHER02A2', 'DESCTEACHER02');
INSERT INTO teacher(first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('TEACHER03', 'M', 'TEACHER03A','TEACHER03A2', 'DESCTEACHER03');
INSERT INTO teacher(first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('TEACHER04', 'M', 'TEACHER04A','TEACHER04A2', 'DESCTEACHER04');
INSERT INTO teacher(first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('TEACHERC1', 'M', 'TEACHERC1A','TEACHERC1A2', 'DESCTEACHERC1');
INSERT INTO teacher(first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('TEACHERC2', 'M', 'TEACHERC2A','TEACHERC2A2', 'DESCTEACHERC2');
INSERT INTO teacher(first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('TEACHERC3', 'M', 'TEACHERC3A','TEACHERC3A2', 'DESCTEACHERC3');
INSERT INTO teacher(first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('TEACHERCLASENEW', 'M', 'TEACHERCLASENEW','TEACHERCLASEA2NEW', 'DESCTEACHERCLASENEW');
INSERT INTO teacher(first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('TEACHERCLASEUPDATE', 'M', 'TEACHERCLASEUPDATE','TEACHERCLASEA2UPDATE', 'DESCTEACHERCLASEUPDATE');
INSERT INTO teacher(first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('TEACHERCLASEDELETE', 'M', 'TEACHERCLASEDELETE','TEACHERCLASEA2DELETE', 'DESCTEACHERCLASEDELETE');
INSERT INTO teacher(first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('TEACHERCLASSSTUDENT', 'M', 'TEACHERCLASSSTUDENT','TEACHERCLASSSTUDENT', 'DESCTEACHERCLASSSTUDENT');
INSERT INTO teacher(first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('TEACHERCLASSSTUDENTLIST', 'M', 'TEACHERCLASSSTUDENTLIST','TEACHERCLASSSTUDENTLIST', 'DESCTEACHERCLASSSTUDENTLIST');
INSERT INTO teacher(first_name, gender, last_name, middle_name, other_teacher_details)VALUES ('TEACHERCLASSSTUDENTLIST2', 'M', 'TEACHERCLASSSTUDENTLIST2','TEACHERCLASSSTUDENTLIST2', 'DESCTEACHERCLASSSTUDENTLIST2');

INSERT INTO class(class_code, class_name, date_from, date_to, subject_id, teacher_id)VALUES ( 'CLASSCODE01', 'CLASSNAME01', '1992-06-03', '1992-07-03', 5, 5);
INSERT INTO class(class_code, class_name, date_from, date_to, subject_id, teacher_id)VALUES ( 'CLASSCODE02', 'CLASSNAME02', '1992-06-03', '1992-07-03', 6, 6);
INSERT INTO class(class_code, class_name, date_from, date_to, subject_id, teacher_id)VALUES ( 'CLASSCODE03', 'CLASSNAME03', '1992-06-03', '1992-07-03', 7, 7);
INSERT INTO class(class_code, class_name, date_from, date_to, subject_id, teacher_id)VALUES ( 'CLASSUPDATE', 'CLASSUPDATE', '1992-06-03', '1992-07-03', 9, 9);
INSERT INTO class(class_code, class_name, date_from, date_to, subject_id, teacher_id)VALUES ( 'CLASSDELETE', 'CLASSDELETE', '1992-06-03', '1992-07-03', 10, 10);
INSERT INTO class(class_code, class_name, date_from, date_to, subject_id, teacher_id)VALUES ( 'CLASSSTUDENTCREATE', 'CLASSSTUDENTCREATE', '1992-06-03', '1992-07-03', 11, 11);
INSERT INTO class(class_code, class_name, date_from, date_to, subject_id, teacher_id)VALUES ( 'CLASSSTUDENTCREATELIST', 'CLASSSTUDENTCREATELIST', '1992-06-03', '1992-07-03', 12, 12);
INSERT INTO class(class_code, class_name, date_from, date_to, subject_id, teacher_id)VALUES ( 'CLASSSTUDENTCREATELIST2', 'CLASSSTUDENTCREATELIST2', '1992-06-03', '1992-07-03', 13, 13);

INSERT INTO students(date_of_birth, first_name, gender, last_name, middle_name, other_student_details)VALUES ('1992-06-03', 'STUDENTCLASSSTUDENT', 'M', 'STUDENTCLASSSTUDENT', 'STUDENTCLASSSTUDENT', 'STUDENTCLASSSTUDENT');
INSERT INTO students(date_of_birth, first_name, gender, last_name, middle_name, other_student_details)VALUES ('1992-06-03', 'STUDENTCLASSSTUDENTLIST1', 'M', 'STUDENTCLASSSTUDENTLIST1', 'STUDENTCLASSSTUDENTLIST1', 'STUDENTCLASSSTUDENTLIST1');
INSERT INTO students(date_of_birth, first_name, gender, last_name, middle_name, other_student_details)VALUES ('1992-06-03', 'STUDENTCLASSSTUDENTLIST2', 'M', 'STUDENTCLASSSTUDENTLIST2', 'STUDENTCLASSSTUDENTLIST2', 'STUDENTCLASSSTUDENTLIST2');

DELETE FROM student_class;

INSERT INTO student_class( class_id, date_from,student_id, date_to)VALUES (7,'1992-06-03',2, '1992-07-03');
--INSERT INTO student_class( class_id, date_from,student_id, date_to)VALUES (8,'1993-07-01',100, '1994-08-01');
--INSERT INTO student_class(date_from, class_id, student_id, date_to)VALUES ('1992-06-03', 7, 3, '1992-07-03');
