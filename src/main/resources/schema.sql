create table student
(
    id            bigint(20) auto_increment primary key comment '主键 ID',
    name          varchar(255)      not null        default '' comment '姓名',
    year          smallint unsigned not null        default 0 comment '入学年份',
    student_no    bigint(20)        not null unique default 0 comment '学号',
    password      varchar(255)      not null        default '' comment '密码',
    `create_time` timestamp         NOT NULL        DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp         NULL            DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    KEY year_student_no (year, student_no)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '学生表';

create table teacher
(
    id            bigint(20) auto_increment primary key comment '主键 ID',
    name          varchar(255)      not null        default '' comment '姓名',
    year          smallint unsigned not null        default 0 comment '入职年份',
    teacher_no    bigint(20)        not null unique default 0 comment '教工号',
    password      varchar(255)      not null        default '' comment '密码',
    `create_time` timestamp         NOT NULL        DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp         NULL            DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP,
    KEY year_teacher_no (year, teacher_no)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '教师表';

create table course
(
    id            bigint(20) auto_increment primary key comment '主键 ID',
    name          varchar(255) not null default '' comment '课程名',
    teacher_id    bigint(20)   not null default 0 comment '教师 ID',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp    NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '课程表';

create table student_course_mapping
(
    id            bigint(20) auto_increment primary key comment '主键 ID',
    student_id    bigint(20) not null default 0 comment '学生 ID',
    course_id     bigint(20) not null default 0 comment '课程 ID',
    `create_time` timestamp  NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp  NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '学生和课程映射关系表';

create table memorandum
(
    id            bigint(20) auto_increment primary key comment '主键 ID',
    content       varchar(2047) not null default '' comment '内容',
    student_id    bigint(20)    not null default 0 comment '学生 ID',
    `create_time` timestamp     NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp     NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '备忘录表';

/********************************问答**************************************************/
create table test
(
    `id`          bigint(20) auto_increment primary key comment '主键 ID',
    `title`       varchar(255) not null default '' comment '测验名称',
    `description` bigint(20)   not null default 0 comment '简单描述',
    `course_id`   bigint(20)   not null default 0 comment '课程 ID',
    `teacher_id`  bigint(20)   not null default 0 comment '教师 ID',
    `create_time` timestamp    NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp    NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '测验表';

create table selection
(
    id            bigint(20) auto_increment primary key comment '主键 ID',
    test_id       bigint(20)        not null default 0 comment '对应的测验 ID',
    question      varchar(2047)     not null default '' comment '问题描述',
    answerType    tinyint           not null default 0 comment '对应问题类型：单选、多选',
    choice_a      varchar(2047)     not null default 0 comment '选项 A',
    choice_b      varchar(2047)     not null default 0 comment '选项 B',
    choice_c      varchar(2047)     not null default 0 comment '选项 C',
    choice_d      varchar(2047)     not null default 0 comment '选项 D',
    answer        varchar(10)       not null default '' comment '答案',
    score         smallint unsigned not null default 1 comment '分值',
    `create_time` timestamp         NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `update_time` timestamp         NULL     DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4 comment '问题表';

