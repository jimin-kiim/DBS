

### where 
- and, or
- is not null, is null

### max, min
- 집계함수(where에서 사용 불가)
- datetime에도 사용 가능
    - 가장 늦은 datetime(가장 최근)이 max. 

#### =, like
- 완전히 동일한 걸 찾을 때: =
- 문자열 패턴 기반 검색: like
  - %
  - _

### join
- from 테이블 join 테이블 on 기준컬럼 = 기준컬럼 
- 두 번도 사용 가능 

### round()
round(대상, 자리수)
- 자리수 생략: 소수 => 정수 
- 양수자리수: 소수점 이하 반올림
- 음수자리수: 십의 자리, 백의 자리 .. 반올림

### count()

### ordery by
- order by 기준 desc/asc
- order by 기준1 desc/asc, 기준2 desc/asc

### date_format()
- date_format(대상, 형식)
- 형식: 예) 2024: '%Y', 03: '%m'

### ifnull()
- ifnull(기준, 표기)
- 예) ifnull(tlno, 'NONE')

### union all
- s/f/w union all s/f/w order by

### in 
- = or = or = 을 줄여 쓸 때 사용
- 서브쿼리와 자주 씀