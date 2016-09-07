package org.kin.live.live_account.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public TransExample() {
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
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andTransAmtIsNull() {
            addCriterion("trans_amt is null");
            return (Criteria) this;
        }

        public Criteria andTransAmtIsNotNull() {
            addCriterion("trans_amt is not null");
            return (Criteria) this;
        }

        public Criteria andTransAmtEqualTo(BigDecimal value) {
            addCriterion("trans_amt =", value, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtNotEqualTo(BigDecimal value) {
            addCriterion("trans_amt <>", value, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtGreaterThan(BigDecimal value) {
            addCriterion("trans_amt >", value, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("trans_amt >=", value, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtLessThan(BigDecimal value) {
            addCriterion("trans_amt <", value, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("trans_amt <=", value, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtIn(List<BigDecimal> values) {
            addCriterion("trans_amt in", values, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtNotIn(List<BigDecimal> values) {
            addCriterion("trans_amt not in", values, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trans_amt between", value1, value2, "transAmt");
            return (Criteria) this;
        }

        public Criteria andTransAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("trans_amt not between", value1, value2, "transAmt");
            return (Criteria) this;
        }

        public Criteria andPayerIdIsNull() {
            addCriterion("payer_id is null");
            return (Criteria) this;
        }

        public Criteria andPayerIdIsNotNull() {
            addCriterion("payer_id is not null");
            return (Criteria) this;
        }

        public Criteria andPayerIdEqualTo(String value) {
            addCriterion("payer_id =", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotEqualTo(String value) {
            addCriterion("payer_id <>", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdGreaterThan(String value) {
            addCriterion("payer_id >", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdGreaterThanOrEqualTo(String value) {
            addCriterion("payer_id >=", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdLessThan(String value) {
            addCriterion("payer_id <", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdLessThanOrEqualTo(String value) {
            addCriterion("payer_id <=", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdLike(String value) {
            addCriterion("payer_id like", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotLike(String value) {
            addCriterion("payer_id not like", value, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdIn(List<String> values) {
            addCriterion("payer_id in", values, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotIn(List<String> values) {
            addCriterion("payer_id not in", values, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdBetween(String value1, String value2) {
            addCriterion("payer_id between", value1, value2, "payerId");
            return (Criteria) this;
        }

        public Criteria andPayerIdNotBetween(String value1, String value2) {
            addCriterion("payer_id not between", value1, value2, "payerId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNull() {
            addCriterion("group_id is null");
            return (Criteria) this;
        }

        public Criteria andGroupIdIsNotNull() {
            addCriterion("group_id is not null");
            return (Criteria) this;
        }

        public Criteria andGroupIdEqualTo(String value) {
            addCriterion("group_id =", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotEqualTo(String value) {
            addCriterion("group_id <>", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThan(String value) {
            addCriterion("group_id >", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdGreaterThanOrEqualTo(String value) {
            addCriterion("group_id >=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThan(String value) {
            addCriterion("group_id <", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLessThanOrEqualTo(String value) {
            addCriterion("group_id <=", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdLike(String value) {
            addCriterion("group_id like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotLike(String value) {
            addCriterion("group_id not like", value, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdIn(List<String> values) {
            addCriterion("group_id in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotIn(List<String> values) {
            addCriterion("group_id not in", values, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdBetween(String value1, String value2) {
            addCriterion("group_id between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andGroupIdNotBetween(String value1, String value2) {
            addCriterion("group_id not between", value1, value2, "groupId");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNull() {
            addCriterion("pay_time is null");
            return (Criteria) this;
        }

        public Criteria andPayTimeIsNotNull() {
            addCriterion("pay_time is not null");
            return (Criteria) this;
        }

        public Criteria andPayTimeEqualTo(Date value) {
            addCriterion("pay_time =", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotEqualTo(Date value) {
            addCriterion("pay_time <>", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThan(Date value) {
            addCriterion("pay_time >", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("pay_time >=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThan(Date value) {
            addCriterion("pay_time <", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeLessThanOrEqualTo(Date value) {
            addCriterion("pay_time <=", value, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeIn(List<Date> values) {
            addCriterion("pay_time in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotIn(List<Date> values) {
            addCriterion("pay_time not in", values, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeBetween(Date value1, Date value2) {
            addCriterion("pay_time between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andPayTimeNotBetween(Date value1, Date value2) {
            addCriterion("pay_time not between", value1, value2, "payTime");
            return (Criteria) this;
        }

        public Criteria andDivideToIsNull() {
            addCriterion("divide_to is null");
            return (Criteria) this;
        }

        public Criteria andDivideToIsNotNull() {
            addCriterion("divide_to is not null");
            return (Criteria) this;
        }

        public Criteria andDivideToEqualTo(Integer value) {
            addCriterion("divide_to =", value, "divideTo");
            return (Criteria) this;
        }

        public Criteria andDivideToNotEqualTo(Integer value) {
            addCriterion("divide_to <>", value, "divideTo");
            return (Criteria) this;
        }

        public Criteria andDivideToGreaterThan(Integer value) {
            addCriterion("divide_to >", value, "divideTo");
            return (Criteria) this;
        }

        public Criteria andDivideToGreaterThanOrEqualTo(Integer value) {
            addCriterion("divide_to >=", value, "divideTo");
            return (Criteria) this;
        }

        public Criteria andDivideToLessThan(Integer value) {
            addCriterion("divide_to <", value, "divideTo");
            return (Criteria) this;
        }

        public Criteria andDivideToLessThanOrEqualTo(Integer value) {
            addCriterion("divide_to <=", value, "divideTo");
            return (Criteria) this;
        }

        public Criteria andDivideToIn(List<Integer> values) {
            addCriterion("divide_to in", values, "divideTo");
            return (Criteria) this;
        }

        public Criteria andDivideToNotIn(List<Integer> values) {
            addCriterion("divide_to not in", values, "divideTo");
            return (Criteria) this;
        }

        public Criteria andDivideToBetween(Integer value1, Integer value2) {
            addCriterion("divide_to between", value1, value2, "divideTo");
            return (Criteria) this;
        }

        public Criteria andDivideToNotBetween(Integer value1, Integer value2) {
            addCriterion("divide_to not between", value1, value2, "divideTo");
            return (Criteria) this;
        }

        public Criteria andPerAmtIsNull() {
            addCriterion("per_amt is null");
            return (Criteria) this;
        }

        public Criteria andPerAmtIsNotNull() {
            addCriterion("per_amt is not null");
            return (Criteria) this;
        }

        public Criteria andPerAmtEqualTo(BigDecimal value) {
            addCriterion("per_amt =", value, "perAmt");
            return (Criteria) this;
        }

        public Criteria andPerAmtNotEqualTo(BigDecimal value) {
            addCriterion("per_amt <>", value, "perAmt");
            return (Criteria) this;
        }

        public Criteria andPerAmtGreaterThan(BigDecimal value) {
            addCriterion("per_amt >", value, "perAmt");
            return (Criteria) this;
        }

        public Criteria andPerAmtGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("per_amt >=", value, "perAmt");
            return (Criteria) this;
        }

        public Criteria andPerAmtLessThan(BigDecimal value) {
            addCriterion("per_amt <", value, "perAmt");
            return (Criteria) this;
        }

        public Criteria andPerAmtLessThanOrEqualTo(BigDecimal value) {
            addCriterion("per_amt <=", value, "perAmt");
            return (Criteria) this;
        }

        public Criteria andPerAmtIn(List<BigDecimal> values) {
            addCriterion("per_amt in", values, "perAmt");
            return (Criteria) this;
        }

        public Criteria andPerAmtNotIn(List<BigDecimal> values) {
            addCriterion("per_amt not in", values, "perAmt");
            return (Criteria) this;
        }

        public Criteria andPerAmtBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_amt between", value1, value2, "perAmt");
            return (Criteria) this;
        }

        public Criteria andPerAmtNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("per_amt not between", value1, value2, "perAmt");
            return (Criteria) this;
        }

        public Criteria andMemoIsNull() {
            addCriterion("memo is null");
            return (Criteria) this;
        }

        public Criteria andMemoIsNotNull() {
            addCriterion("memo is not null");
            return (Criteria) this;
        }

        public Criteria andMemoEqualTo(String value) {
            addCriterion("memo =", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotEqualTo(String value) {
            addCriterion("memo <>", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThan(String value) {
            addCriterion("memo >", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoGreaterThanOrEqualTo(String value) {
            addCriterion("memo >=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThan(String value) {
            addCriterion("memo <", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLessThanOrEqualTo(String value) {
            addCriterion("memo <=", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoLike(String value) {
            addCriterion("memo like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotLike(String value) {
            addCriterion("memo not like", value, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoIn(List<String> values) {
            addCriterion("memo in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotIn(List<String> values) {
            addCriterion("memo not in", values, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoBetween(String value1, String value2) {
            addCriterion("memo between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andMemoNotBetween(String value1, String value2) {
            addCriterion("memo not between", value1, value2, "memo");
            return (Criteria) this;
        }

        public Criteria andImageIsNull() {
            addCriterion("image is null");
            return (Criteria) this;
        }

        public Criteria andImageIsNotNull() {
            addCriterion("image is not null");
            return (Criteria) this;
        }

        public Criteria andImageEqualTo(String value) {
            addCriterion("image =", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotEqualTo(String value) {
            addCriterion("image <>", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThan(String value) {
            addCriterion("image >", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageGreaterThanOrEqualTo(String value) {
            addCriterion("image >=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThan(String value) {
            addCriterion("image <", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLessThanOrEqualTo(String value) {
            addCriterion("image <=", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageLike(String value) {
            addCriterion("image like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotLike(String value) {
            addCriterion("image not like", value, "image");
            return (Criteria) this;
        }

        public Criteria andImageIn(List<String> values) {
            addCriterion("image in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotIn(List<String> values) {
            addCriterion("image not in", values, "image");
            return (Criteria) this;
        }

        public Criteria andImageBetween(String value1, String value2) {
            addCriterion("image between", value1, value2, "image");
            return (Criteria) this;
        }

        public Criteria andImageNotBetween(String value1, String value2) {
            addCriterion("image not between", value1, value2, "image");
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