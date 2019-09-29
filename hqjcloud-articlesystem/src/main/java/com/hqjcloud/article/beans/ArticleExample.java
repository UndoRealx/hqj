package com.hqjcloud.article.beans;

import java.util.ArrayList;
import java.util.List;

public class ArticleExample {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    protected String orderByClause;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    protected boolean distinct;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    protected List<Criteria> oredCriteria;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    public ArticleExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
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

        public Criteria andLongidIsNull() {
            addCriterion("longid is null");
            return (Criteria) this;
        }

        public Criteria andLongidIsNotNull() {
            addCriterion("longid is not null");
            return (Criteria) this;
        }

        public Criteria andLongidEqualTo(Long value) {
            addCriterion("longid =", value, "longid");
            return (Criteria) this;
        }

        public Criteria andLongidNotEqualTo(Long value) {
            addCriterion("longid <>", value, "longid");
            return (Criteria) this;
        }

        public Criteria andLongidGreaterThan(Long value) {
            addCriterion("longid >", value, "longid");
            return (Criteria) this;
        }

        public Criteria andLongidGreaterThanOrEqualTo(Long value) {
            addCriterion("longid >=", value, "longid");
            return (Criteria) this;
        }

        public Criteria andLongidLessThan(Long value) {
            addCriterion("longid <", value, "longid");
            return (Criteria) this;
        }

        public Criteria andLongidLessThanOrEqualTo(Long value) {
            addCriterion("longid <=", value, "longid");
            return (Criteria) this;
        }

        public Criteria andLongidIn(List<Long> values) {
            addCriterion("longid in", values, "longid");
            return (Criteria) this;
        }

        public Criteria andLongidNotIn(List<Long> values) {
            addCriterion("longid not in", values, "longid");
            return (Criteria) this;
        }

        public Criteria andLongidBetween(Long value1, Long value2) {
            addCriterion("longid between", value1, value2, "longid");
            return (Criteria) this;
        }

        public Criteria andLongidNotBetween(Long value1, Long value2) {
            addCriterion("longid not between", value1, value2, "longid");
            return (Criteria) this;
        }

        public Criteria andArttitleIsNull() {
            addCriterion("arttitle is null");
            return (Criteria) this;
        }

        public Criteria andArttitleIsNotNull() {
            addCriterion("arttitle is not null");
            return (Criteria) this;
        }

        public Criteria andArttitleEqualTo(String value) {
            addCriterion("arttitle =", value, "arttitle");
            return (Criteria) this;
        }

        public Criteria andArttitleNotEqualTo(String value) {
            addCriterion("arttitle <>", value, "arttitle");
            return (Criteria) this;
        }

        public Criteria andArttitleGreaterThan(String value) {
            addCriterion("arttitle >", value, "arttitle");
            return (Criteria) this;
        }

        public Criteria andArttitleGreaterThanOrEqualTo(String value) {
            addCriterion("arttitle >=", value, "arttitle");
            return (Criteria) this;
        }

        public Criteria andArttitleLessThan(String value) {
            addCriterion("arttitle <", value, "arttitle");
            return (Criteria) this;
        }

        public Criteria andArttitleLessThanOrEqualTo(String value) {
            addCriterion("arttitle <=", value, "arttitle");
            return (Criteria) this;
        }

        public Criteria andArttitleLike(String value) {
            addCriterion("arttitle like", value, "arttitle");
            return (Criteria) this;
        }

        public Criteria andArttitleNotLike(String value) {
            addCriterion("arttitle not like", value, "arttitle");
            return (Criteria) this;
        }

        public Criteria andArttitleIn(List<String> values) {
            addCriterion("arttitle in", values, "arttitle");
            return (Criteria) this;
        }

        public Criteria andArttitleNotIn(List<String> values) {
            addCriterion("arttitle not in", values, "arttitle");
            return (Criteria) this;
        }

        public Criteria andArttitleBetween(String value1, String value2) {
            addCriterion("arttitle between", value1, value2, "arttitle");
            return (Criteria) this;
        }

        public Criteria andArttitleNotBetween(String value1, String value2) {
            addCriterion("arttitle not between", value1, value2, "arttitle");
            return (Criteria) this;
        }

        public Criteria andArtabstractIsNull() {
            addCriterion("artabstract is null");
            return (Criteria) this;
        }

        public Criteria andArtabstractIsNotNull() {
            addCriterion("artabstract is not null");
            return (Criteria) this;
        }

        public Criteria andArtabstractEqualTo(String value) {
            addCriterion("artabstract =", value, "artabstract");
            return (Criteria) this;
        }

        public Criteria andArtabstractNotEqualTo(String value) {
            addCriterion("artabstract <>", value, "artabstract");
            return (Criteria) this;
        }

        public Criteria andArtabstractGreaterThan(String value) {
            addCriterion("artabstract >", value, "artabstract");
            return (Criteria) this;
        }

        public Criteria andArtabstractGreaterThanOrEqualTo(String value) {
            addCriterion("artabstract >=", value, "artabstract");
            return (Criteria) this;
        }

        public Criteria andArtabstractLessThan(String value) {
            addCriterion("artabstract <", value, "artabstract");
            return (Criteria) this;
        }

        public Criteria andArtabstractLessThanOrEqualTo(String value) {
            addCriterion("artabstract <=", value, "artabstract");
            return (Criteria) this;
        }

        public Criteria andArtabstractLike(String value) {
            addCriterion("artabstract like", value, "artabstract");
            return (Criteria) this;
        }

        public Criteria andArtabstractNotLike(String value) {
            addCriterion("artabstract not like", value, "artabstract");
            return (Criteria) this;
        }

        public Criteria andArtabstractIn(List<String> values) {
            addCriterion("artabstract in", values, "artabstract");
            return (Criteria) this;
        }

        public Criteria andArtabstractNotIn(List<String> values) {
            addCriterion("artabstract not in", values, "artabstract");
            return (Criteria) this;
        }

        public Criteria andArtabstractBetween(String value1, String value2) {
            addCriterion("artabstract between", value1, value2, "artabstract");
            return (Criteria) this;
        }

        public Criteria andArtabstractNotBetween(String value1, String value2) {
            addCriterion("artabstract not between", value1, value2, "artabstract");
            return (Criteria) this;
        }

        public Criteria andArtimageIsNull() {
            addCriterion("artimage is null");
            return (Criteria) this;
        }

        public Criteria andArtimageIsNotNull() {
            addCriterion("artimage is not null");
            return (Criteria) this;
        }

        public Criteria andArtimageEqualTo(String value) {
            addCriterion("artimage =", value, "artimage");
            return (Criteria) this;
        }

        public Criteria andArtimageNotEqualTo(String value) {
            addCriterion("artimage <>", value, "artimage");
            return (Criteria) this;
        }

        public Criteria andArtimageGreaterThan(String value) {
            addCriterion("artimage >", value, "artimage");
            return (Criteria) this;
        }

        public Criteria andArtimageGreaterThanOrEqualTo(String value) {
            addCriterion("artimage >=", value, "artimage");
            return (Criteria) this;
        }

        public Criteria andArtimageLessThan(String value) {
            addCriterion("artimage <", value, "artimage");
            return (Criteria) this;
        }

        public Criteria andArtimageLessThanOrEqualTo(String value) {
            addCriterion("artimage <=", value, "artimage");
            return (Criteria) this;
        }

        public Criteria andArtimageLike(String value) {
            addCriterion("artimage like", value, "artimage");
            return (Criteria) this;
        }

        public Criteria andArtimageNotLike(String value) {
            addCriterion("artimage not like", value, "artimage");
            return (Criteria) this;
        }

        public Criteria andArtimageIn(List<String> values) {
            addCriterion("artimage in", values, "artimage");
            return (Criteria) this;
        }

        public Criteria andArtimageNotIn(List<String> values) {
            addCriterion("artimage not in", values, "artimage");
            return (Criteria) this;
        }

        public Criteria andArtimageBetween(String value1, String value2) {
            addCriterion("artimage between", value1, value2, "artimage");
            return (Criteria) this;
        }

        public Criteria andArtimageNotBetween(String value1, String value2) {
            addCriterion("artimage not between", value1, value2, "artimage");
            return (Criteria) this;
        }

        public Criteria andVisitcntIsNull() {
            addCriterion("visitcnt is null");
            return (Criteria) this;
        }

        public Criteria andVisitcntIsNotNull() {
            addCriterion("visitcnt is not null");
            return (Criteria) this;
        }

        public Criteria andVisitcntEqualTo(Integer value) {
            addCriterion("visitcnt =", value, "visitcnt");
            return (Criteria) this;
        }

        public Criteria andVisitcntNotEqualTo(Integer value) {
            addCriterion("visitcnt <>", value, "visitcnt");
            return (Criteria) this;
        }

        public Criteria andVisitcntGreaterThan(Integer value) {
            addCriterion("visitcnt >", value, "visitcnt");
            return (Criteria) this;
        }

        public Criteria andVisitcntGreaterThanOrEqualTo(Integer value) {
            addCriterion("visitcnt >=", value, "visitcnt");
            return (Criteria) this;
        }

        public Criteria andVisitcntLessThan(Integer value) {
            addCriterion("visitcnt <", value, "visitcnt");
            return (Criteria) this;
        }

        public Criteria andVisitcntLessThanOrEqualTo(Integer value) {
            addCriterion("visitcnt <=", value, "visitcnt");
            return (Criteria) this;
        }

        public Criteria andVisitcntIn(List<Integer> values) {
            addCriterion("visitcnt in", values, "visitcnt");
            return (Criteria) this;
        }

        public Criteria andVisitcntNotIn(List<Integer> values) {
            addCriterion("visitcnt not in", values, "visitcnt");
            return (Criteria) this;
        }

        public Criteria andVisitcntBetween(Integer value1, Integer value2) {
            addCriterion("visitcnt between", value1, value2, "visitcnt");
            return (Criteria) this;
        }

        public Criteria andVisitcntNotBetween(Integer value1, Integer value2) {
            addCriterion("visitcnt not between", value1, value2, "visitcnt");
            return (Criteria) this;
        }

        public Criteria andArtstatusIsNull() {
            addCriterion("artstatus is null");
            return (Criteria) this;
        }

        public Criteria andArtstatusIsNotNull() {
            addCriterion("artstatus is not null");
            return (Criteria) this;
        }

        public Criteria andArtstatusEqualTo(Integer value) {
            addCriterion("artstatus =", value, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusNotEqualTo(Integer value) {
            addCriterion("artstatus <>", value, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusGreaterThan(Integer value) {
            addCriterion("artstatus >", value, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusGreaterThanOrEqualTo(Integer value) {
            addCriterion("artstatus >=", value, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusLessThan(Integer value) {
            addCriterion("artstatus <", value, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusLessThanOrEqualTo(Integer value) {
            addCriterion("artstatus <=", value, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusIn(List<Integer> values) {
            addCriterion("artstatus in", values, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusNotIn(List<Integer> values) {
            addCriterion("artstatus not in", values, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusBetween(Integer value1, Integer value2) {
            addCriterion("artstatus between", value1, value2, "artstatus");
            return (Criteria) this;
        }

        public Criteria andArtstatusNotBetween(Integer value1, Integer value2) {
            addCriterion("artstatus not between", value1, value2, "artstatus");
            return (Criteria) this;
        }

        public Criteria andLikesIsNull() {
            addCriterion("likes is null");
            return (Criteria) this;
        }

        public Criteria andLikesIsNotNull() {
            addCriterion("likes is not null");
            return (Criteria) this;
        }

        public Criteria andLikesEqualTo(Integer value) {
            addCriterion("likes =", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotEqualTo(Integer value) {
            addCriterion("likes <>", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesGreaterThan(Integer value) {
            addCriterion("likes >", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesGreaterThanOrEqualTo(Integer value) {
            addCriterion("likes >=", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesLessThan(Integer value) {
            addCriterion("likes <", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesLessThanOrEqualTo(Integer value) {
            addCriterion("likes <=", value, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesIn(List<Integer> values) {
            addCriterion("likes in", values, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotIn(List<Integer> values) {
            addCriterion("likes not in", values, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesBetween(Integer value1, Integer value2) {
            addCriterion("likes between", value1, value2, "likes");
            return (Criteria) this;
        }

        public Criteria andLikesNotBetween(Integer value1, Integer value2) {
            addCriterion("likes not between", value1, value2, "likes");
            return (Criteria) this;
        }

        public Criteria andAddauthorIsNull() {
            addCriterion("addauthor is null");
            return (Criteria) this;
        }

        public Criteria andAddauthorIsNotNull() {
            addCriterion("addauthor is not null");
            return (Criteria) this;
        }

        public Criteria andAddauthorEqualTo(String value) {
            addCriterion("addauthor =", value, "addauthor");
            return (Criteria) this;
        }

        public Criteria andAddauthorNotEqualTo(String value) {
            addCriterion("addauthor <>", value, "addauthor");
            return (Criteria) this;
        }

        public Criteria andAddauthorGreaterThan(String value) {
            addCriterion("addauthor >", value, "addauthor");
            return (Criteria) this;
        }

        public Criteria andAddauthorGreaterThanOrEqualTo(String value) {
            addCriterion("addauthor >=", value, "addauthor");
            return (Criteria) this;
        }

        public Criteria andAddauthorLessThan(String value) {
            addCriterion("addauthor <", value, "addauthor");
            return (Criteria) this;
        }

        public Criteria andAddauthorLessThanOrEqualTo(String value) {
            addCriterion("addauthor <=", value, "addauthor");
            return (Criteria) this;
        }

        public Criteria andAddauthorLike(String value) {
            addCriterion("addauthor like", value, "addauthor");
            return (Criteria) this;
        }

        public Criteria andAddauthorNotLike(String value) {
            addCriterion("addauthor not like", value, "addauthor");
            return (Criteria) this;
        }

        public Criteria andAddauthorIn(List<String> values) {
            addCriterion("addauthor in", values, "addauthor");
            return (Criteria) this;
        }

        public Criteria andAddauthorNotIn(List<String> values) {
            addCriterion("addauthor not in", values, "addauthor");
            return (Criteria) this;
        }

        public Criteria andAddauthorBetween(String value1, String value2) {
            addCriterion("addauthor between", value1, value2, "addauthor");
            return (Criteria) this;
        }

        public Criteria andAddauthorNotBetween(String value1, String value2) {
            addCriterion("addauthor not between", value1, value2, "addauthor");
            return (Criteria) this;
        }

        public Criteria andArtsortIsNull() {
            addCriterion("artSort is null");
            return (Criteria) this;
        }

        public Criteria andArtsortIsNotNull() {
            addCriterion("artSort is not null");
            return (Criteria) this;
        }

        public Criteria andArtsortEqualTo(Integer value) {
            addCriterion("artSort =", value, "artsort");
            return (Criteria) this;
        }

        public Criteria andArtsortNotEqualTo(Integer value) {
            addCriterion("artSort <>", value, "artsort");
            return (Criteria) this;
        }

        public Criteria andArtsortGreaterThan(Integer value) {
            addCriterion("artSort >", value, "artsort");
            return (Criteria) this;
        }

        public Criteria andArtsortGreaterThanOrEqualTo(Integer value) {
            addCriterion("artSort >=", value, "artsort");
            return (Criteria) this;
        }

        public Criteria andArtsortLessThan(Integer value) {
            addCriterion("artSort <", value, "artsort");
            return (Criteria) this;
        }

        public Criteria andArtsortLessThanOrEqualTo(Integer value) {
            addCriterion("artSort <=", value, "artsort");
            return (Criteria) this;
        }

        public Criteria andArtsortIn(List<Integer> values) {
            addCriterion("artSort in", values, "artsort");
            return (Criteria) this;
        }

        public Criteria andArtsortNotIn(List<Integer> values) {
            addCriterion("artSort not in", values, "artsort");
            return (Criteria) this;
        }

        public Criteria andArtsortBetween(Integer value1, Integer value2) {
            addCriterion("artSort between", value1, value2, "artsort");
            return (Criteria) this;
        }

        public Criteria andArtsortNotBetween(Integer value1, Integer value2) {
            addCriterion("artSort not between", value1, value2, "artsort");
            return (Criteria) this;
        }

        public Criteria andIstopIsNull() {
            addCriterion("istop is null");
            return (Criteria) this;
        }

        public Criteria andIstopIsNotNull() {
            addCriterion("istop is not null");
            return (Criteria) this;
        }

        public Criteria andIstopEqualTo(Byte value) {
            addCriterion("istop =", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotEqualTo(Byte value) {
            addCriterion("istop <>", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThan(Byte value) {
            addCriterion("istop >", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopGreaterThanOrEqualTo(Byte value) {
            addCriterion("istop >=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThan(Byte value) {
            addCriterion("istop <", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopLessThanOrEqualTo(Byte value) {
            addCriterion("istop <=", value, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopIn(List<Byte> values) {
            addCriterion("istop in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotIn(List<Byte> values) {
            addCriterion("istop not in", values, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopBetween(Byte value1, Byte value2) {
            addCriterion("istop between", value1, value2, "istop");
            return (Criteria) this;
        }

        public Criteria andIstopNotBetween(Byte value1, Byte value2) {
            addCriterion("istop not between", value1, value2, "istop");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNull() {
            addCriterion("addtime is null");
            return (Criteria) this;
        }

        public Criteria andAddtimeIsNotNull() {
            addCriterion("addtime is not null");
            return (Criteria) this;
        }

        public Criteria andAddtimeEqualTo(Long value) {
            addCriterion("addtime =", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotEqualTo(Long value) {
            addCriterion("addtime <>", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThan(Long value) {
            addCriterion("addtime >", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeGreaterThanOrEqualTo(Long value) {
            addCriterion("addtime >=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThan(Long value) {
            addCriterion("addtime <", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeLessThanOrEqualTo(Long value) {
            addCriterion("addtime <=", value, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeIn(List<Long> values) {
            addCriterion("addtime in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotIn(List<Long> values) {
            addCriterion("addtime not in", values, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeBetween(Long value1, Long value2) {
            addCriterion("addtime between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andAddtimeNotBetween(Long value1, Long value2) {
            addCriterion("addtime not between", value1, value2, "addtime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNull() {
            addCriterion("modifytime is null");
            return (Criteria) this;
        }

        public Criteria andModifytimeIsNotNull() {
            addCriterion("modifytime is not null");
            return (Criteria) this;
        }

        public Criteria andModifytimeEqualTo(Long value) {
            addCriterion("modifytime =", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotEqualTo(Long value) {
            addCriterion("modifytime <>", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThan(Long value) {
            addCriterion("modifytime >", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeGreaterThanOrEqualTo(Long value) {
            addCriterion("modifytime >=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThan(Long value) {
            addCriterion("modifytime <", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeLessThanOrEqualTo(Long value) {
            addCriterion("modifytime <=", value, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeIn(List<Long> values) {
            addCriterion("modifytime in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotIn(List<Long> values) {
            addCriterion("modifytime not in", values, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeBetween(Long value1, Long value2) {
            addCriterion("modifytime between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andModifytimeNotBetween(Long value1, Long value2) {
            addCriterion("modifytime not between", value1, value2, "modifytime");
            return (Criteria) this;
        }

        public Criteria andPubtimeIsNull() {
            addCriterion("pubtime is null");
            return (Criteria) this;
        }

        public Criteria andPubtimeIsNotNull() {
            addCriterion("pubtime is not null");
            return (Criteria) this;
        }

        public Criteria andPubtimeEqualTo(Long value) {
            addCriterion("pubtime =", value, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeNotEqualTo(Long value) {
            addCriterion("pubtime <>", value, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeGreaterThan(Long value) {
            addCriterion("pubtime >", value, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeGreaterThanOrEqualTo(Long value) {
            addCriterion("pubtime >=", value, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeLessThan(Long value) {
            addCriterion("pubtime <", value, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeLessThanOrEqualTo(Long value) {
            addCriterion("pubtime <=", value, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeIn(List<Long> values) {
            addCriterion("pubtime in", values, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeNotIn(List<Long> values) {
            addCriterion("pubtime not in", values, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeBetween(Long value1, Long value2) {
            addCriterion("pubtime between", value1, value2, "pubtime");
            return (Criteria) this;
        }

        public Criteria andPubtimeNotBetween(Long value1, Long value2) {
            addCriterion("pubtime not between", value1, value2, "pubtime");
            return (Criteria) this;
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table hqj_article
     *
     * @mbg.generated do_not_delete_during_merge
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    /**
     * This class was generated by MyBatis Generator.
     * This class corresponds to the database table hqj_article
     *
     * @mbg.generated
     */
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