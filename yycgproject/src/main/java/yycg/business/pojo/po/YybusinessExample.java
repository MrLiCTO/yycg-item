package yycg.business.pojo.po;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class YybusinessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public YybusinessExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andYycgdidIsNull() {
            addCriterion("YYCGDID is null");
            return (Criteria) this;
        }

        public Criteria andYycgdidIsNotNull() {
            addCriterion("YYCGDID is not null");
            return (Criteria) this;
        }

        public Criteria andYycgdidEqualTo(String value) {
            addCriterion("YYCGDID =", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidNotEqualTo(String value) {
            addCriterion("YYCGDID <>", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidGreaterThan(String value) {
            addCriterion("YYCGDID >", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidGreaterThanOrEqualTo(String value) {
            addCriterion("YYCGDID >=", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidLessThan(String value) {
            addCriterion("YYCGDID <", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidLessThanOrEqualTo(String value) {
            addCriterion("YYCGDID <=", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidLike(String value) {
            addCriterion("YYCGDID like", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidNotLike(String value) {
            addCriterion("YYCGDID not like", value, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidIn(List<String> values) {
            addCriterion("YYCGDID in", values, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidNotIn(List<String> values) {
            addCriterion("YYCGDID not in", values, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidBetween(String value1, String value2) {
            addCriterion("YYCGDID between", value1, value2, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andYycgdidNotBetween(String value1, String value2) {
            addCriterion("YYCGDID not between", value1, value2, "yycgdid");
            return (Criteria) this;
        }

        public Criteria andUseryyidIsNull() {
            addCriterion("USERYYID is null");
            return (Criteria) this;
        }

        public Criteria andUseryyidIsNotNull() {
            addCriterion("USERYYID is not null");
            return (Criteria) this;
        }

        public Criteria andUseryyidEqualTo(String value) {
            addCriterion("USERYYID =", value, "useryyid");
            return (Criteria) this;
        }

        public Criteria andUseryyidNotEqualTo(String value) {
            addCriterion("USERYYID <>", value, "useryyid");
            return (Criteria) this;
        }

        public Criteria andUseryyidGreaterThan(String value) {
            addCriterion("USERYYID >", value, "useryyid");
            return (Criteria) this;
        }

        public Criteria andUseryyidGreaterThanOrEqualTo(String value) {
            addCriterion("USERYYID >=", value, "useryyid");
            return (Criteria) this;
        }

        public Criteria andUseryyidLessThan(String value) {
            addCriterion("USERYYID <", value, "useryyid");
            return (Criteria) this;
        }

        public Criteria andUseryyidLessThanOrEqualTo(String value) {
            addCriterion("USERYYID <=", value, "useryyid");
            return (Criteria) this;
        }

        public Criteria andUseryyidLike(String value) {
            addCriterion("USERYYID like", value, "useryyid");
            return (Criteria) this;
        }

        public Criteria andUseryyidNotLike(String value) {
            addCriterion("USERYYID not like", value, "useryyid");
            return (Criteria) this;
        }

        public Criteria andUseryyidIn(List<String> values) {
            addCriterion("USERYYID in", values, "useryyid");
            return (Criteria) this;
        }

        public Criteria andUseryyidNotIn(List<String> values) {
            addCriterion("USERYYID not in", values, "useryyid");
            return (Criteria) this;
        }

        public Criteria andUseryyidBetween(String value1, String value2) {
            addCriterion("USERYYID between", value1, value2, "useryyid");
            return (Criteria) this;
        }

        public Criteria andUseryyidNotBetween(String value1, String value2) {
            addCriterion("USERYYID not between", value1, value2, "useryyid");
            return (Criteria) this;
        }

        public Criteria andYpxxidIsNull() {
            addCriterion("YPXXID is null");
            return (Criteria) this;
        }

        public Criteria andYpxxidIsNotNull() {
            addCriterion("YPXXID is not null");
            return (Criteria) this;
        }

        public Criteria andYpxxidEqualTo(String value) {
            addCriterion("YPXXID =", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidNotEqualTo(String value) {
            addCriterion("YPXXID <>", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidGreaterThan(String value) {
            addCriterion("YPXXID >", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidGreaterThanOrEqualTo(String value) {
            addCriterion("YPXXID >=", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidLessThan(String value) {
            addCriterion("YPXXID <", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidLessThanOrEqualTo(String value) {
            addCriterion("YPXXID <=", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidLike(String value) {
            addCriterion("YPXXID like", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidNotLike(String value) {
            addCriterion("YPXXID not like", value, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidIn(List<String> values) {
            addCriterion("YPXXID in", values, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidNotIn(List<String> values) {
            addCriterion("YPXXID not in", values, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidBetween(String value1, String value2) {
            addCriterion("YPXXID between", value1, value2, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andYpxxidNotBetween(String value1, String value2) {
            addCriterion("YPXXID not between", value1, value2, "ypxxid");
            return (Criteria) this;
        }

        public Criteria andZbjgIsNull() {
            addCriterion("ZBJG is null");
            return (Criteria) this;
        }

        public Criteria andZbjgIsNotNull() {
            addCriterion("ZBJG is not null");
            return (Criteria) this;
        }

        public Criteria andZbjgEqualTo(Float value) {
            addCriterion("ZBJG =", value, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgNotEqualTo(Float value) {
            addCriterion("ZBJG <>", value, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgGreaterThan(Float value) {
            addCriterion("ZBJG >", value, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgGreaterThanOrEqualTo(Float value) {
            addCriterion("ZBJG >=", value, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgLessThan(Float value) {
            addCriterion("ZBJG <", value, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgLessThanOrEqualTo(Float value) {
            addCriterion("ZBJG <=", value, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgIn(List<Float> values) {
            addCriterion("ZBJG in", values, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgNotIn(List<Float> values) {
            addCriterion("ZBJG not in", values, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgBetween(Float value1, Float value2) {
            addCriterion("ZBJG between", value1, value2, "zbjg");
            return (Criteria) this;
        }

        public Criteria andZbjgNotBetween(Float value1, Float value2) {
            addCriterion("ZBJG not between", value1, value2, "zbjg");
            return (Criteria) this;
        }

        public Criteria andJyjgIsNull() {
            addCriterion("JYJG is null");
            return (Criteria) this;
        }

        public Criteria andJyjgIsNotNull() {
            addCriterion("JYJG is not null");
            return (Criteria) this;
        }

        public Criteria andJyjgEqualTo(Float value) {
            addCriterion("JYJG =", value, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgNotEqualTo(Float value) {
            addCriterion("JYJG <>", value, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgGreaterThan(Float value) {
            addCriterion("JYJG >", value, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgGreaterThanOrEqualTo(Float value) {
            addCriterion("JYJG >=", value, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgLessThan(Float value) {
            addCriterion("JYJG <", value, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgLessThanOrEqualTo(Float value) {
            addCriterion("JYJG <=", value, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgIn(List<Float> values) {
            addCriterion("JYJG in", values, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgNotIn(List<Float> values) {
            addCriterion("JYJG not in", values, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgBetween(Float value1, Float value2) {
            addCriterion("JYJG between", value1, value2, "jyjg");
            return (Criteria) this;
        }

        public Criteria andJyjgNotBetween(Float value1, Float value2) {
            addCriterion("JYJG not between", value1, value2, "jyjg");
            return (Criteria) this;
        }

        public Criteria andCglIsNull() {
            addCriterion("CGL is null");
            return (Criteria) this;
        }

        public Criteria andCglIsNotNull() {
            addCriterion("CGL is not null");
            return (Criteria) this;
        }

        public Criteria andCglEqualTo(Integer value) {
            addCriterion("CGL =", value, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglNotEqualTo(Integer value) {
            addCriterion("CGL <>", value, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglGreaterThan(Integer value) {
            addCriterion("CGL >", value, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglGreaterThanOrEqualTo(Integer value) {
            addCriterion("CGL >=", value, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglLessThan(Integer value) {
            addCriterion("CGL <", value, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglLessThanOrEqualTo(Integer value) {
            addCriterion("CGL <=", value, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglIn(List<Integer> values) {
            addCriterion("CGL in", values, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglNotIn(List<Integer> values) {
            addCriterion("CGL not in", values, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglBetween(Integer value1, Integer value2) {
            addCriterion("CGL between", value1, value2, "cgl");
            return (Criteria) this;
        }

        public Criteria andCglNotBetween(Integer value1, Integer value2) {
            addCriterion("CGL not between", value1, value2, "cgl");
            return (Criteria) this;
        }

        public Criteria andCgjeIsNull() {
            addCriterion("CGJE is null");
            return (Criteria) this;
        }

        public Criteria andCgjeIsNotNull() {
            addCriterion("CGJE is not null");
            return (Criteria) this;
        }

        public Criteria andCgjeEqualTo(Float value) {
            addCriterion("CGJE =", value, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeNotEqualTo(Float value) {
            addCriterion("CGJE <>", value, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeGreaterThan(Float value) {
            addCriterion("CGJE >", value, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeGreaterThanOrEqualTo(Float value) {
            addCriterion("CGJE >=", value, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeLessThan(Float value) {
            addCriterion("CGJE <", value, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeLessThanOrEqualTo(Float value) {
            addCriterion("CGJE <=", value, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeIn(List<Float> values) {
            addCriterion("CGJE in", values, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeNotIn(List<Float> values) {
            addCriterion("CGJE not in", values, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeBetween(Float value1, Float value2) {
            addCriterion("CGJE between", value1, value2, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgjeNotBetween(Float value1, Float value2) {
            addCriterion("CGJE not between", value1, value2, "cgje");
            return (Criteria) this;
        }

        public Criteria andCgztIsNull() {
            addCriterion("CGZT is null");
            return (Criteria) this;
        }

        public Criteria andCgztIsNotNull() {
            addCriterion("CGZT is not null");
            return (Criteria) this;
        }

        public Criteria andCgztEqualTo(String value) {
            addCriterion("CGZT =", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztNotEqualTo(String value) {
            addCriterion("CGZT <>", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztGreaterThan(String value) {
            addCriterion("CGZT >", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztGreaterThanOrEqualTo(String value) {
            addCriterion("CGZT >=", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztLessThan(String value) {
            addCriterion("CGZT <", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztLessThanOrEqualTo(String value) {
            addCriterion("CGZT <=", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztLike(String value) {
            addCriterion("CGZT like", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztNotLike(String value) {
            addCriterion("CGZT not like", value, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztIn(List<String> values) {
            addCriterion("CGZT in", values, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztNotIn(List<String> values) {
            addCriterion("CGZT not in", values, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztBetween(String value1, String value2) {
            addCriterion("CGZT between", value1, value2, "cgzt");
            return (Criteria) this;
        }

        public Criteria andCgztNotBetween(String value1, String value2) {
            addCriterion("CGZT not between", value1, value2, "cgzt");
            return (Criteria) this;
        }

        public Criteria andRklIsNull() {
            addCriterion("RKL is null");
            return (Criteria) this;
        }

        public Criteria andRklIsNotNull() {
            addCriterion("RKL is not null");
            return (Criteria) this;
        }

        public Criteria andRklEqualTo(Integer value) {
            addCriterion("RKL =", value, "rkl");
            return (Criteria) this;
        }

        public Criteria andRklNotEqualTo(Integer value) {
            addCriterion("RKL <>", value, "rkl");
            return (Criteria) this;
        }

        public Criteria andRklGreaterThan(Integer value) {
            addCriterion("RKL >", value, "rkl");
            return (Criteria) this;
        }

        public Criteria andRklGreaterThanOrEqualTo(Integer value) {
            addCriterion("RKL >=", value, "rkl");
            return (Criteria) this;
        }

        public Criteria andRklLessThan(Integer value) {
            addCriterion("RKL <", value, "rkl");
            return (Criteria) this;
        }

        public Criteria andRklLessThanOrEqualTo(Integer value) {
            addCriterion("RKL <=", value, "rkl");
            return (Criteria) this;
        }

        public Criteria andRklIn(List<Integer> values) {
            addCriterion("RKL in", values, "rkl");
            return (Criteria) this;
        }

        public Criteria andRklNotIn(List<Integer> values) {
            addCriterion("RKL not in", values, "rkl");
            return (Criteria) this;
        }

        public Criteria andRklBetween(Integer value1, Integer value2) {
            addCriterion("RKL between", value1, value2, "rkl");
            return (Criteria) this;
        }

        public Criteria andRklNotBetween(Integer value1, Integer value2) {
            addCriterion("RKL not between", value1, value2, "rkl");
            return (Criteria) this;
        }

        public Criteria andRkjeIsNull() {
            addCriterion("RKJE is null");
            return (Criteria) this;
        }

        public Criteria andRkjeIsNotNull() {
            addCriterion("RKJE is not null");
            return (Criteria) this;
        }

        public Criteria andRkjeEqualTo(Float value) {
            addCriterion("RKJE =", value, "rkje");
            return (Criteria) this;
        }

        public Criteria andRkjeNotEqualTo(Float value) {
            addCriterion("RKJE <>", value, "rkje");
            return (Criteria) this;
        }

        public Criteria andRkjeGreaterThan(Float value) {
            addCriterion("RKJE >", value, "rkje");
            return (Criteria) this;
        }

        public Criteria andRkjeGreaterThanOrEqualTo(Float value) {
            addCriterion("RKJE >=", value, "rkje");
            return (Criteria) this;
        }

        public Criteria andRkjeLessThan(Float value) {
            addCriterion("RKJE <", value, "rkje");
            return (Criteria) this;
        }

        public Criteria andRkjeLessThanOrEqualTo(Float value) {
            addCriterion("RKJE <=", value, "rkje");
            return (Criteria) this;
        }

        public Criteria andRkjeIn(List<Float> values) {
            addCriterion("RKJE in", values, "rkje");
            return (Criteria) this;
        }

        public Criteria andRkjeNotIn(List<Float> values) {
            addCriterion("RKJE not in", values, "rkje");
            return (Criteria) this;
        }

        public Criteria andRkjeBetween(Float value1, Float value2) {
            addCriterion("RKJE between", value1, value2, "rkje");
            return (Criteria) this;
        }

        public Criteria andRkjeNotBetween(Float value1, Float value2) {
            addCriterion("RKJE not between", value1, value2, "rkje");
            return (Criteria) this;
        }

        public Criteria andRkdhIsNull() {
            addCriterion("RKDH is null");
            return (Criteria) this;
        }

        public Criteria andRkdhIsNotNull() {
            addCriterion("RKDH is not null");
            return (Criteria) this;
        }

        public Criteria andRkdhEqualTo(String value) {
            addCriterion("RKDH =", value, "rkdh");
            return (Criteria) this;
        }

        public Criteria andRkdhNotEqualTo(String value) {
            addCriterion("RKDH <>", value, "rkdh");
            return (Criteria) this;
        }

        public Criteria andRkdhGreaterThan(String value) {
            addCriterion("RKDH >", value, "rkdh");
            return (Criteria) this;
        }

        public Criteria andRkdhGreaterThanOrEqualTo(String value) {
            addCriterion("RKDH >=", value, "rkdh");
            return (Criteria) this;
        }

        public Criteria andRkdhLessThan(String value) {
            addCriterion("RKDH <", value, "rkdh");
            return (Criteria) this;
        }

        public Criteria andRkdhLessThanOrEqualTo(String value) {
            addCriterion("RKDH <=", value, "rkdh");
            return (Criteria) this;
        }

        public Criteria andRkdhLike(String value) {
            addCriterion("RKDH like", value, "rkdh");
            return (Criteria) this;
        }

        public Criteria andRkdhNotLike(String value) {
            addCriterion("RKDH not like", value, "rkdh");
            return (Criteria) this;
        }

        public Criteria andRkdhIn(List<String> values) {
            addCriterion("RKDH in", values, "rkdh");
            return (Criteria) this;
        }

        public Criteria andRkdhNotIn(List<String> values) {
            addCriterion("RKDH not in", values, "rkdh");
            return (Criteria) this;
        }

        public Criteria andRkdhBetween(String value1, String value2) {
            addCriterion("RKDH between", value1, value2, "rkdh");
            return (Criteria) this;
        }

        public Criteria andRkdhNotBetween(String value1, String value2) {
            addCriterion("RKDH not between", value1, value2, "rkdh");
            return (Criteria) this;
        }

        public Criteria andYpphIsNull() {
            addCriterion("YPPH is null");
            return (Criteria) this;
        }

        public Criteria andYpphIsNotNull() {
            addCriterion("YPPH is not null");
            return (Criteria) this;
        }

        public Criteria andYpphEqualTo(String value) {
            addCriterion("YPPH =", value, "ypph");
            return (Criteria) this;
        }

        public Criteria andYpphNotEqualTo(String value) {
            addCriterion("YPPH <>", value, "ypph");
            return (Criteria) this;
        }

        public Criteria andYpphGreaterThan(String value) {
            addCriterion("YPPH >", value, "ypph");
            return (Criteria) this;
        }

        public Criteria andYpphGreaterThanOrEqualTo(String value) {
            addCriterion("YPPH >=", value, "ypph");
            return (Criteria) this;
        }

        public Criteria andYpphLessThan(String value) {
            addCriterion("YPPH <", value, "ypph");
            return (Criteria) this;
        }

        public Criteria andYpphLessThanOrEqualTo(String value) {
            addCriterion("YPPH <=", value, "ypph");
            return (Criteria) this;
        }

        public Criteria andYpphLike(String value) {
            addCriterion("YPPH like", value, "ypph");
            return (Criteria) this;
        }

        public Criteria andYpphNotLike(String value) {
            addCriterion("YPPH not like", value, "ypph");
            return (Criteria) this;
        }

        public Criteria andYpphIn(List<String> values) {
            addCriterion("YPPH in", values, "ypph");
            return (Criteria) this;
        }

        public Criteria andYpphNotIn(List<String> values) {
            addCriterion("YPPH not in", values, "ypph");
            return (Criteria) this;
        }

        public Criteria andYpphBetween(String value1, String value2) {
            addCriterion("YPPH between", value1, value2, "ypph");
            return (Criteria) this;
        }

        public Criteria andYpphNotBetween(String value1, String value2) {
            addCriterion("YPPH not between", value1, value2, "ypph");
            return (Criteria) this;
        }

        public Criteria andYpyxqIsNull() {
            addCriterion("YPYXQ is null");
            return (Criteria) this;
        }

        public Criteria andYpyxqIsNotNull() {
            addCriterion("YPYXQ is not null");
            return (Criteria) this;
        }

        public Criteria andYpyxqEqualTo(Float value) {
            addCriterion("YPYXQ =", value, "ypyxq");
            return (Criteria) this;
        }

        public Criteria andYpyxqNotEqualTo(Float value) {
            addCriterion("YPYXQ <>", value, "ypyxq");
            return (Criteria) this;
        }

        public Criteria andYpyxqGreaterThan(Float value) {
            addCriterion("YPYXQ >", value, "ypyxq");
            return (Criteria) this;
        }

        public Criteria andYpyxqGreaterThanOrEqualTo(Float value) {
            addCriterion("YPYXQ >=", value, "ypyxq");
            return (Criteria) this;
        }

        public Criteria andYpyxqLessThan(Float value) {
            addCriterion("YPYXQ <", value, "ypyxq");
            return (Criteria) this;
        }

        public Criteria andYpyxqLessThanOrEqualTo(Float value) {
            addCriterion("YPYXQ <=", value, "ypyxq");
            return (Criteria) this;
        }

        public Criteria andYpyxqIn(List<Float> values) {
            addCriterion("YPYXQ in", values, "ypyxq");
            return (Criteria) this;
        }

        public Criteria andYpyxqNotIn(List<Float> values) {
            addCriterion("YPYXQ not in", values, "ypyxq");
            return (Criteria) this;
        }

        public Criteria andYpyxqBetween(Float value1, Float value2) {
            addCriterion("YPYXQ between", value1, value2, "ypyxq");
            return (Criteria) this;
        }

        public Criteria andYpyxqNotBetween(Float value1, Float value2) {
            addCriterion("YPYXQ not between", value1, value2, "ypyxq");
            return (Criteria) this;
        }

        public Criteria andRktimeIsNull() {
            addCriterion("RKTIME is null");
            return (Criteria) this;
        }

        public Criteria andRktimeIsNotNull() {
            addCriterion("RKTIME is not null");
            return (Criteria) this;
        }

        public Criteria andRktimeEqualTo(Date value) {
            addCriterion("RKTIME =", value, "rktime");
            return (Criteria) this;
        }

        public Criteria andRktimeNotEqualTo(Date value) {
            addCriterion("RKTIME <>", value, "rktime");
            return (Criteria) this;
        }

        public Criteria andRktimeGreaterThan(Date value) {
            addCriterion("RKTIME >", value, "rktime");
            return (Criteria) this;
        }

        public Criteria andRktimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RKTIME >=", value, "rktime");
            return (Criteria) this;
        }

        public Criteria andRktimeLessThan(Date value) {
            addCriterion("RKTIME <", value, "rktime");
            return (Criteria) this;
        }

        public Criteria andRktimeLessThanOrEqualTo(Date value) {
            addCriterion("RKTIME <=", value, "rktime");
            return (Criteria) this;
        }

        public Criteria andRktimeIn(List<Date> values) {
            addCriterion("RKTIME in", values, "rktime");
            return (Criteria) this;
        }

        public Criteria andRktimeNotIn(List<Date> values) {
            addCriterion("RKTIME not in", values, "rktime");
            return (Criteria) this;
        }

        public Criteria andRktimeBetween(Date value1, Date value2) {
            addCriterion("RKTIME between", value1, value2, "rktime");
            return (Criteria) this;
        }

        public Criteria andRktimeNotBetween(Date value1, Date value2) {
            addCriterion("RKTIME not between", value1, value2, "rktime");
            return (Criteria) this;
        }

        public Criteria andFhtimeIsNull() {
            addCriterion("FHTIME is null");
            return (Criteria) this;
        }

        public Criteria andFhtimeIsNotNull() {
            addCriterion("FHTIME is not null");
            return (Criteria) this;
        }

        public Criteria andFhtimeEqualTo(Date value) {
            addCriterion("FHTIME =", value, "fhtime");
            return (Criteria) this;
        }

        public Criteria andFhtimeNotEqualTo(Date value) {
            addCriterion("FHTIME <>", value, "fhtime");
            return (Criteria) this;
        }

        public Criteria andFhtimeGreaterThan(Date value) {
            addCriterion("FHTIME >", value, "fhtime");
            return (Criteria) this;
        }

        public Criteria andFhtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FHTIME >=", value, "fhtime");
            return (Criteria) this;
        }

        public Criteria andFhtimeLessThan(Date value) {
            addCriterion("FHTIME <", value, "fhtime");
            return (Criteria) this;
        }

        public Criteria andFhtimeLessThanOrEqualTo(Date value) {
            addCriterion("FHTIME <=", value, "fhtime");
            return (Criteria) this;
        }

        public Criteria andFhtimeIn(List<Date> values) {
            addCriterion("FHTIME in", values, "fhtime");
            return (Criteria) this;
        }

        public Criteria andFhtimeNotIn(List<Date> values) {
            addCriterion("FHTIME not in", values, "fhtime");
            return (Criteria) this;
        }

        public Criteria andFhtimeBetween(Date value1, Date value2) {
            addCriterion("FHTIME between", value1, value2, "fhtime");
            return (Criteria) this;
        }

        public Criteria andFhtimeNotBetween(Date value1, Date value2) {
            addCriterion("FHTIME not between", value1, value2, "fhtime");
            return (Criteria) this;
        }

        public Criteria andYythdidIsNull() {
            addCriterion("YYTHDID is null");
            return (Criteria) this;
        }

        public Criteria andYythdidIsNotNull() {
            addCriterion("YYTHDID is not null");
            return (Criteria) this;
        }

        public Criteria andYythdidEqualTo(String value) {
            addCriterion("YYTHDID =", value, "yythdid");
            return (Criteria) this;
        }

        public Criteria andYythdidNotEqualTo(String value) {
            addCriterion("YYTHDID <>", value, "yythdid");
            return (Criteria) this;
        }

        public Criteria andYythdidGreaterThan(String value) {
            addCriterion("YYTHDID >", value, "yythdid");
            return (Criteria) this;
        }

        public Criteria andYythdidGreaterThanOrEqualTo(String value) {
            addCriterion("YYTHDID >=", value, "yythdid");
            return (Criteria) this;
        }

        public Criteria andYythdidLessThan(String value) {
            addCriterion("YYTHDID <", value, "yythdid");
            return (Criteria) this;
        }

        public Criteria andYythdidLessThanOrEqualTo(String value) {
            addCriterion("YYTHDID <=", value, "yythdid");
            return (Criteria) this;
        }

        public Criteria andYythdidLike(String value) {
            addCriterion("YYTHDID like", value, "yythdid");
            return (Criteria) this;
        }

        public Criteria andYythdidNotLike(String value) {
            addCriterion("YYTHDID not like", value, "yythdid");
            return (Criteria) this;
        }

        public Criteria andYythdidIn(List<String> values) {
            addCriterion("YYTHDID in", values, "yythdid");
            return (Criteria) this;
        }

        public Criteria andYythdidNotIn(List<String> values) {
            addCriterion("YYTHDID not in", values, "yythdid");
            return (Criteria) this;
        }

        public Criteria andYythdidBetween(String value1, String value2) {
            addCriterion("YYTHDID between", value1, value2, "yythdid");
            return (Criteria) this;
        }

        public Criteria andYythdidNotBetween(String value1, String value2) {
            addCriterion("YYTHDID not between", value1, value2, "yythdid");
            return (Criteria) this;
        }

        public Criteria andThlIsNull() {
            addCriterion("THL is null");
            return (Criteria) this;
        }

        public Criteria andThlIsNotNull() {
            addCriterion("THL is not null");
            return (Criteria) this;
        }

        public Criteria andThlEqualTo(Integer value) {
            addCriterion("THL =", value, "thl");
            return (Criteria) this;
        }

        public Criteria andThlNotEqualTo(Integer value) {
            addCriterion("THL <>", value, "thl");
            return (Criteria) this;
        }

        public Criteria andThlGreaterThan(Integer value) {
            addCriterion("THL >", value, "thl");
            return (Criteria) this;
        }

        public Criteria andThlGreaterThanOrEqualTo(Integer value) {
            addCriterion("THL >=", value, "thl");
            return (Criteria) this;
        }

        public Criteria andThlLessThan(Integer value) {
            addCriterion("THL <", value, "thl");
            return (Criteria) this;
        }

        public Criteria andThlLessThanOrEqualTo(Integer value) {
            addCriterion("THL <=", value, "thl");
            return (Criteria) this;
        }

        public Criteria andThlLike(Integer value) {
            addCriterion("THL like", value, "thl");
            return (Criteria) this;
        }

        public Criteria andThlNotLike(Integer value) {
            addCriterion("THL not like", value, "thl");
            return (Criteria) this;
        }

        public Criteria andThlIn(List<Integer> values) {
            addCriterion("THL in", values, "thl");
            return (Criteria) this;
        }

        public Criteria andThlNotIn(List<Integer> values) {
            addCriterion("THL not in", values, "thl");
            return (Criteria) this;
        }

        public Criteria andThlBetween(Integer value1, Integer value2) {
            addCriterion("THL between", value1, value2, "thl");
            return (Criteria) this;
        }

        public Criteria andThlNotBetween(Integer value1, Integer value2) {
            addCriterion("THL not between", value1, value2, "thl");
            return (Criteria) this;
        }

        public Criteria andThjeIsNull() {
            addCriterion("THJE is null");
            return (Criteria) this;
        }

        public Criteria andThjeIsNotNull() {
            addCriterion("THJE is not null");
            return (Criteria) this;
        }

        public Criteria andThjeEqualTo(Float value) {
            addCriterion("THJE =", value, "thje");
            return (Criteria) this;
        }

        public Criteria andThjeNotEqualTo(Float value) {
            addCriterion("THJE <>", value, "thje");
            return (Criteria) this;
        }

        public Criteria andThjeGreaterThan(Float value) {
            addCriterion("THJE >", value, "thje");
            return (Criteria) this;
        }

        public Criteria andThjeGreaterThanOrEqualTo(Float value) {
            addCriterion("THJE >=", value, "thje");
            return (Criteria) this;
        }

        public Criteria andThjeLessThan(Float value) {
            addCriterion("THJE <", value, "thje");
            return (Criteria) this;
        }

        public Criteria andThjeLessThanOrEqualTo(Float value) {
            addCriterion("THJE <=", value, "thje");
            return (Criteria) this;
        }

        public Criteria andThjeIn(List<Float> values) {
            addCriterion("THJE in", values, "thje");
            return (Criteria) this;
        }

        public Criteria andThjeNotIn(List<Float> values) {
            addCriterion("THJE not in", values, "thje");
            return (Criteria) this;
        }

        public Criteria andThjeBetween(Float value1, Float value2) {
            addCriterion("THJE between", value1, value2, "thje");
            return (Criteria) this;
        }

        public Criteria andThjeNotBetween(Float value1, Float value2) {
            addCriterion("THJE not between", value1, value2, "thje");
            return (Criteria) this;
        }

        public Criteria andThztIsNull() {
            addCriterion("THZT is null");
            return (Criteria) this;
        }

        public Criteria andThztIsNotNull() {
            addCriterion("THZT is not null");
            return (Criteria) this;
        }

        public Criteria andThztEqualTo(String value) {
            addCriterion("THZT =", value, "thzt");
            return (Criteria) this;
        }

        public Criteria andThztNotEqualTo(String value) {
            addCriterion("THZT <>", value, "thzt");
            return (Criteria) this;
        }

        public Criteria andThztGreaterThan(String value) {
            addCriterion("THZT >", value, "thzt");
            return (Criteria) this;
        }

        public Criteria andThztGreaterThanOrEqualTo(String value) {
            addCriterion("THZT >=", value, "thzt");
            return (Criteria) this;
        }

        public Criteria andThztLessThan(String value) {
            addCriterion("THZT <", value, "thzt");
            return (Criteria) this;
        }

        public Criteria andThztLessThanOrEqualTo(String value) {
            addCriterion("THZT <=", value, "thzt");
            return (Criteria) this;
        }

        public Criteria andThztLike(String value) {
            addCriterion("THZT like", value, "thzt");
            return (Criteria) this;
        }

        public Criteria andThztNotLike(String value) {
            addCriterion("THZT not like", value, "thzt");
            return (Criteria) this;
        }

        public Criteria andThztIn(List<String> values) {
            addCriterion("THZT in", values, "thzt");
            return (Criteria) this;
        }

        public Criteria andThztNotIn(List<String> values) {
            addCriterion("THZT not in", values, "thzt");
            return (Criteria) this;
        }

        public Criteria andThztBetween(String value1, String value2) {
            addCriterion("THZT between", value1, value2, "thzt");
            return (Criteria) this;
        }

        public Criteria andThztNotBetween(String value1, String value2) {
            addCriterion("THZT not between", value1, value2, "thzt");
            return (Criteria) this;
        }

        public Criteria andThyyIsNull() {
            addCriterion("THYY is null");
            return (Criteria) this;
        }

        public Criteria andThyyIsNotNull() {
            addCriterion("THYY is not null");
            return (Criteria) this;
        }

        public Criteria andThyyEqualTo(String value) {
            addCriterion("THYY =", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyNotEqualTo(String value) {
            addCriterion("THYY <>", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyGreaterThan(String value) {
            addCriterion("THYY >", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyGreaterThanOrEqualTo(String value) {
            addCriterion("THYY >=", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyLessThan(String value) {
            addCriterion("THYY <", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyLessThanOrEqualTo(String value) {
            addCriterion("THYY <=", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyLike(String value) {
            addCriterion("THYY like", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyNotLike(String value) {
            addCriterion("THYY not like", value, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyIn(List<String> values) {
            addCriterion("THYY in", values, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyNotIn(List<String> values) {
            addCriterion("THYY not in", values, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyBetween(String value1, String value2) {
            addCriterion("THYY between", value1, value2, "thyy");
            return (Criteria) this;
        }

        public Criteria andThyyNotBetween(String value1, String value2) {
            addCriterion("THYY not between", value1, value2, "thyy");
            return (Criteria) this;
        }

        public Criteria andYyjsdidIsNull() {
            addCriterion("YYJSDID is null");
            return (Criteria) this;
        }

        public Criteria andYyjsdidIsNotNull() {
            addCriterion("YYJSDID is not null");
            return (Criteria) this;
        }

        public Criteria andYyjsdidEqualTo(String value) {
            addCriterion("YYJSDID =", value, "yyjsdid");
            return (Criteria) this;
        }

        public Criteria andYyjsdidNotEqualTo(String value) {
            addCriterion("YYJSDID <>", value, "yyjsdid");
            return (Criteria) this;
        }

        public Criteria andYyjsdidGreaterThan(String value) {
            addCriterion("YYJSDID >", value, "yyjsdid");
            return (Criteria) this;
        }

        public Criteria andYyjsdidGreaterThanOrEqualTo(String value) {
            addCriterion("YYJSDID >=", value, "yyjsdid");
            return (Criteria) this;
        }

        public Criteria andYyjsdidLessThan(String value) {
            addCriterion("YYJSDID <", value, "yyjsdid");
            return (Criteria) this;
        }

        public Criteria andYyjsdidLessThanOrEqualTo(String value) {
            addCriterion("YYJSDID <=", value, "yyjsdid");
            return (Criteria) this;
        }

        public Criteria andYyjsdidLike(String value) {
            addCriterion("YYJSDID like", value, "yyjsdid");
            return (Criteria) this;
        }

        public Criteria andYyjsdidNotLike(String value) {
            addCriterion("YYJSDID not like", value, "yyjsdid");
            return (Criteria) this;
        }

        public Criteria andYyjsdidIn(List<String> values) {
            addCriterion("YYJSDID in", values, "yyjsdid");
            return (Criteria) this;
        }

        public Criteria andYyjsdidNotIn(List<String> values) {
            addCriterion("YYJSDID not in", values, "yyjsdid");
            return (Criteria) this;
        }

        public Criteria andYyjsdidBetween(String value1, String value2) {
            addCriterion("YYJSDID between", value1, value2, "yyjsdid");
            return (Criteria) this;
        }

        public Criteria andYyjsdidNotBetween(String value1, String value2) {
            addCriterion("YYJSDID not between", value1, value2, "yyjsdid");
            return (Criteria) this;
        }

        public Criteria andJslIsNull() {
            addCriterion("JSL is null");
            return (Criteria) this;
        }

        public Criteria andJslIsNotNull() {
            addCriterion("JSL is not null");
            return (Criteria) this;
        }

        public Criteria andJslEqualTo(Integer value) {
            addCriterion("JSL =", value, "jsl");
            return (Criteria) this;
        }

        public Criteria andJslNotEqualTo(Integer value) {
            addCriterion("JSL <>", value, "jsl");
            return (Criteria) this;
        }

        public Criteria andJslGreaterThan(Integer value) {
            addCriterion("JSL >", value, "jsl");
            return (Criteria) this;
        }

        public Criteria andJslGreaterThanOrEqualTo(Integer value) {
            addCriterion("JSL >=", value, "jsl");
            return (Criteria) this;
        }

        public Criteria andJslLessThan(Integer value) {
            addCriterion("JSL <", value, "jsl");
            return (Criteria) this;
        }

        public Criteria andJslLessThanOrEqualTo(Integer value) {
            addCriterion("JSL <=", value, "jsl");
            return (Criteria) this;
        }

        public Criteria andJslIn(List<Integer> values) {
            addCriterion("JSL in", values, "jsl");
            return (Criteria) this;
        }

        public Criteria andJslNotIn(List<Integer> values) {
            addCriterion("JSL not in", values, "jsl");
            return (Criteria) this;
        }

        public Criteria andJslBetween(Integer value1, Integer value2) {
            addCriterion("JSL between", value1, value2, "jsl");
            return (Criteria) this;
        }

        public Criteria andJslNotBetween(Integer value1, Integer value2) {
            addCriterion("JSL not between", value1, value2, "jsl");
            return (Criteria) this;
        }

        public Criteria andJsjeIsNull() {
            addCriterion("JSJE is null");
            return (Criteria) this;
        }

        public Criteria andJsjeIsNotNull() {
            addCriterion("JSJE is not null");
            return (Criteria) this;
        }

        public Criteria andJsjeEqualTo(Float value) {
            addCriterion("JSJE =", value, "jsje");
            return (Criteria) this;
        }

        public Criteria andJsjeNotEqualTo(Float value) {
            addCriterion("JSJE <>", value, "jsje");
            return (Criteria) this;
        }

        public Criteria andJsjeGreaterThan(Float value) {
            addCriterion("JSJE >", value, "jsje");
            return (Criteria) this;
        }

        public Criteria andJsjeGreaterThanOrEqualTo(Float value) {
            addCriterion("JSJE >=", value, "jsje");
            return (Criteria) this;
        }

        public Criteria andJsjeLessThan(Float value) {
            addCriterion("JSJE <", value, "jsje");
            return (Criteria) this;
        }

        public Criteria andJsjeLessThanOrEqualTo(Float value) {
            addCriterion("JSJE <=", value, "jsje");
            return (Criteria) this;
        }

        public Criteria andJsjeIn(List<Float> values) {
            addCriterion("JSJE in", values, "jsje");
            return (Criteria) this;
        }

        public Criteria andJsjeNotIn(List<Float> values) {
            addCriterion("JSJE not in", values, "jsje");
            return (Criteria) this;
        }

        public Criteria andJsjeBetween(Float value1, Float value2) {
            addCriterion("JSJE between", value1, value2, "jsje");
            return (Criteria) this;
        }

        public Criteria andJsjeNotBetween(Float value1, Float value2) {
            addCriterion("JSJE not between", value1, value2, "jsje");
            return (Criteria) this;
        }

        public Criteria andJsztIsNull() {
            addCriterion("JSZT is null");
            return (Criteria) this;
        }

        public Criteria andJsztIsNotNull() {
            addCriterion("JSZT is not null");
            return (Criteria) this;
        }

        public Criteria andJsztEqualTo(String value) {
            addCriterion("JSZT =", value, "jszt");
            return (Criteria) this;
        }

        public Criteria andJsztNotEqualTo(String value) {
            addCriterion("JSZT <>", value, "jszt");
            return (Criteria) this;
        }

        public Criteria andJsztGreaterThan(String value) {
            addCriterion("JSZT >", value, "jszt");
            return (Criteria) this;
        }

        public Criteria andJsztGreaterThanOrEqualTo(String value) {
            addCriterion("JSZT >=", value, "jszt");
            return (Criteria) this;
        }

        public Criteria andJsztLessThan(String value) {
            addCriterion("JSZT <", value, "jszt");
            return (Criteria) this;
        }

        public Criteria andJsztLessThanOrEqualTo(String value) {
            addCriterion("JSZT <=", value, "jszt");
            return (Criteria) this;
        }

        public Criteria andJsztLike(String value) {
            addCriterion("JSZT like", value, "jszt");
            return (Criteria) this;
        }

        public Criteria andJsztNotLike(String value) {
            addCriterion("JSZT not like", value, "jszt");
            return (Criteria) this;
        }

        public Criteria andJsztIn(List<String> values) {
            addCriterion("JSZT in", values, "jszt");
            return (Criteria) this;
        }

        public Criteria andJsztNotIn(List<String> values) {
            addCriterion("JSZT not in", values, "jszt");
            return (Criteria) this;
        }

        public Criteria andJsztBetween(String value1, String value2) {
            addCriterion("JSZT between", value1, value2, "jszt");
            return (Criteria) this;
        }

        public Criteria andJsztNotBetween(String value1, String value2) {
            addCriterion("JSZT not between", value1, value2, "jszt");
            return (Criteria) this;
        }

        public Criteria andVchar1IsNull() {
            addCriterion("VCHAR1 is null");
            return (Criteria) this;
        }

        public Criteria andVchar1IsNotNull() {
            addCriterion("VCHAR1 is not null");
            return (Criteria) this;
        }

        public Criteria andVchar1EqualTo(String value) {
            addCriterion("VCHAR1 =", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1NotEqualTo(String value) {
            addCriterion("VCHAR1 <>", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1GreaterThan(String value) {
            addCriterion("VCHAR1 >", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1GreaterThanOrEqualTo(String value) {
            addCriterion("VCHAR1 >=", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1LessThan(String value) {
            addCriterion("VCHAR1 <", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1LessThanOrEqualTo(String value) {
            addCriterion("VCHAR1 <=", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1Like(String value) {
            addCriterion("VCHAR1 like", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1NotLike(String value) {
            addCriterion("VCHAR1 not like", value, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1In(List<String> values) {
            addCriterion("VCHAR1 in", values, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1NotIn(List<String> values) {
            addCriterion("VCHAR1 not in", values, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1Between(String value1, String value2) {
            addCriterion("VCHAR1 between", value1, value2, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar1NotBetween(String value1, String value2) {
            addCriterion("VCHAR1 not between", value1, value2, "vchar1");
            return (Criteria) this;
        }

        public Criteria andVchar2IsNull() {
            addCriterion("VCHAR2 is null");
            return (Criteria) this;
        }

        public Criteria andVchar2IsNotNull() {
            addCriterion("VCHAR2 is not null");
            return (Criteria) this;
        }

        public Criteria andVchar2EqualTo(String value) {
            addCriterion("VCHAR2 =", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2NotEqualTo(String value) {
            addCriterion("VCHAR2 <>", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2GreaterThan(String value) {
            addCriterion("VCHAR2 >", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2GreaterThanOrEqualTo(String value) {
            addCriterion("VCHAR2 >=", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2LessThan(String value) {
            addCriterion("VCHAR2 <", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2LessThanOrEqualTo(String value) {
            addCriterion("VCHAR2 <=", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2Like(String value) {
            addCriterion("VCHAR2 like", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2NotLike(String value) {
            addCriterion("VCHAR2 not like", value, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2In(List<String> values) {
            addCriterion("VCHAR2 in", values, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2NotIn(List<String> values) {
            addCriterion("VCHAR2 not in", values, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2Between(String value1, String value2) {
            addCriterion("VCHAR2 between", value1, value2, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar2NotBetween(String value1, String value2) {
            addCriterion("VCHAR2 not between", value1, value2, "vchar2");
            return (Criteria) this;
        }

        public Criteria andVchar3IsNull() {
            addCriterion("VCHAR3 is null");
            return (Criteria) this;
        }

        public Criteria andVchar3IsNotNull() {
            addCriterion("VCHAR3 is not null");
            return (Criteria) this;
        }

        public Criteria andVchar3EqualTo(String value) {
            addCriterion("VCHAR3 =", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3NotEqualTo(String value) {
            addCriterion("VCHAR3 <>", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3GreaterThan(String value) {
            addCriterion("VCHAR3 >", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3GreaterThanOrEqualTo(String value) {
            addCriterion("VCHAR3 >=", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3LessThan(String value) {
            addCriterion("VCHAR3 <", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3LessThanOrEqualTo(String value) {
            addCriterion("VCHAR3 <=", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3Like(String value) {
            addCriterion("VCHAR3 like", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3NotLike(String value) {
            addCriterion("VCHAR3 not like", value, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3In(List<String> values) {
            addCriterion("VCHAR3 in", values, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3NotIn(List<String> values) {
            addCriterion("VCHAR3 not in", values, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3Between(String value1, String value2) {
            addCriterion("VCHAR3 between", value1, value2, "vchar3");
            return (Criteria) this;
        }

        public Criteria andVchar3NotBetween(String value1, String value2) {
            addCriterion("VCHAR3 not between", value1, value2, "vchar3");
            return (Criteria) this;
        }

        public Criteria andUsergysidIsNull() {
            addCriterion("USERGYSID is null");
            return (Criteria) this;
        }

        public Criteria andUsergysidIsNotNull() {
            addCriterion("USERGYSID is not null");
            return (Criteria) this;
        }

        public Criteria andUsergysidEqualTo(String value) {
            addCriterion("USERGYSID =", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidNotEqualTo(String value) {
            addCriterion("USERGYSID <>", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidGreaterThan(String value) {
            addCriterion("USERGYSID >", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidGreaterThanOrEqualTo(String value) {
            addCriterion("USERGYSID >=", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidLessThan(String value) {
            addCriterion("USERGYSID <", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidLessThanOrEqualTo(String value) {
            addCriterion("USERGYSID <=", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidLike(String value) {
            addCriterion("USERGYSID like", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidNotLike(String value) {
            addCriterion("USERGYSID not like", value, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidIn(List<String> values) {
            addCriterion("USERGYSID in", values, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidNotIn(List<String> values) {
            addCriterion("USERGYSID not in", values, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidBetween(String value1, String value2) {
            addCriterion("USERGYSID between", value1, value2, "usergysid");
            return (Criteria) this;
        }

        public Criteria andUsergysidNotBetween(String value1, String value2) {
            addCriterion("USERGYSID not between", value1, value2, "usergysid");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}