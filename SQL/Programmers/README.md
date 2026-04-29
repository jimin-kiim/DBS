

### where 
- and, or
- is not null

### join
- from 테이블 join 테이블 on 기준컬럼 = 기준컬럼 

### round()
round(대상, 자리수)
- 자리수 생략: 소수 => 정수 
- 양수자리수: 소수점 이하 반올림
- 음수자리수: 십의 자리, 백의 자리 .. 반올림

### ordery by
- order by 기준 desc/asc
- order by 기준1 desc/asc, 기준2 desc/asc

### date_format()
- date_format(대상, 형식)
- 형식: 예) 2024: '%Y', 03: '%m'

### ifnull()
- ifnull(기준, 표기)
- 예) ifnull(tlno, 'NONE')