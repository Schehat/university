package de.hsh.steam.entities;

import jakarta.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * Class Rating
 */
@XmlRootElement(name = "ratings")
public class Rating implements Serializable {

    private static final long serialVersionUID = -7806234457596021877L;

    private Score score;
    private String remark;
    private User ratingUser;
    private Series ratedSeries;

    public Rating() {
    }

    /**
     * Constructor
     *
     * @param score
     * @param remark
     * @param ratingUser
     * @param ratedSeries
     */
    public Rating(Score score, String remark, User ratingUser, Series ratedSeries) {
        super();
        this.score = score;
        this.remark = remark;
        this.ratingUser = ratingUser;
        this.ratedSeries = ratedSeries;
    }

    /**
     * @return Score
     */
    public Score getScore() {
        return score;
    }

    /**
     * @param score
     */
    public void setScore(Score score) {
        this.score = score;
    }

    /**
     * @return String
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return User
     */
    public User getRatingUser() {
        return ratingUser;
    }

    /**
     * @param ratingUser
     */
    public void setRatingUser(User ratingUser) {
        this.ratingUser = ratingUser;
    }

    /**
     * @return Series
     */
    public Series getRatedSeries() {
        return ratedSeries;
    }

    /**
     * @param ratedSeries
     */
    public void setRatedSeries(Series ratedSeries) {
        this.ratedSeries = ratedSeries;
    }

    @Override
    public String toString() {
        return "{"
                + " score='" + getScore() + "'"
                + ", remark='" + getRemark() + "'"
                + ", ratingUser='" + getRatingUser() + "'"
                + ", ratedSeries='" + getRatedSeries() + "'"
                + "}";
    }

}
