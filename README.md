## 테이블 설계
EXPEND: 지출 본체 테이블 <br>
EXPEND_CLIENT: EXPEND 와 CLIENT 간 다대다(N:M) 관계를 풀어내는 테이블 <br>
CLIENT: 거래처 정보 테이블 <br>
EXPEND_SUBJECT: EXPEND 의 지출 항목 테이블 <br>
ACCOUNT_SUBJECT: EXPEND_SUBJECT 가 어떤 회계 계정(ACCOUNT_SUBJECT)에 속하는지를 나타내도록 구성 <br>

## 엔티티 관계도(ERD)
![image](https://github.com/user-attachments/assets/e0cc47ac-c9c7-470d-9ce9-754a3571d65c)

## DDL
```sql
CREATE TABLE EXPEND ( 
    exp_no BIGINT PRIMARY KEY AUTO_INCREMENT, 
    exp_date DATE NOT NULL COMMENT '지출 날짜', 
    total_amt DECIMAL(18, 2) NOT NULL COMMENT '총 지출 금액', 
    description VARCHAR(255) COMMENT '지출 설명', 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일시',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일시'
); 


CREATE TABLE CLIENT ( 
    clt_cd BIGINT PRIMARY KEY AUTO_INCREMENT, 
    name VARCHAR(255) NOT NULL COMMENT '거래처명', 
    contact VARCHAR(50) COMMENT '연락처', 
    email VARCHAR(100) COMMENT '이메일', 
    address VARCHAR(255) COMMENT '주소', 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일시', 
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일시'
);

-- 같은 거래처에 대한 중복 지출은 있을 수 없으므로 별도의 pk를 두지않고 복합키로 둠
-- EXPEND와 CLIENT와의 다대다 관계를 풀어주는 매핑테이블
CREATE TABLE EXPEND_CLIENT (
    exp_no BIGINT NOT NULL COMMENT '지출 ID',
    clt_cd BIGINT NOT NULL COMMENT '거래처 ID',
    amt DECIMAL(18, 2) NOT NULL COMMENT '해당 거래처의 지출 금액',
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일시',
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일시',
    PRIMARY KEY (exp_no, clt_cd),
    CONSTRAINT fk_expend_client_expend FOREIGN KEY (exp_no) REFERENCES EXPEND(exp_no) ON DELETE CASCADE,
    CONSTRAINT fk_expend_client_client FOREIGN KEY (clt_cd) REFERENCES CLIENT(clt_cd) ON DELETE CASCADE
);


CREATE TABLE ACCOUNT_SUBJECT ( 
    sbj_cd BIGINT PRIMARY KEY AUTO_INCREMENT, 
    sbj_nm VARCHAR(255) NOT NULL COMMENT '회계 계정명', 
    description VARCHAR(255) COMMENT '회계 계정 설명', 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일시', 
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일시' 
);

-- 같은 예산과목에 대한 중복 지출은 있을 수 없으므로 별도의 pk를 두지않고 복합키로 둠
-- EXPEND와 ACCOUNT_SUBJECT와의 다대다 관계를 풀어주는 매핑테이블
CREATE TABLE EXPEND_SUBJECT ( 
    exp_no BIGINT NOT NULL COMMENT '지출 ID', 
    acc_sbj BIGINT NOT NULL COMMENT '회계 계정 ID', 
    acc_sbj_nm VARCHAR(255) NOT NULL COMMENT '지출 항목명', 
    amt DECIMAL(18, 2) NOT NULL COMMENT '해당 항목의 지출 금액', 
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP COMMENT '생성 일시', 
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '수정 일시', 
    PRIMARY KEY (exp_no, acc_sbj),
    CONSTRAINT fk_expend_subject_expend FOREIGN KEY (exp_no) REFERENCES EXPEND(exp_no) ON DELETE CASCADE, 
    CONSTRAINT fk_expend_subject_account FOREIGN KEY (acc_sbj) REFERENCES ACCOUNT_SUBJECT(sbj_cd) ON DELETE CASCADE
);

```
