package vip.wicp.ruhome.system.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author pengyu
 * @since 2019-08-06
 */
@TableName("biz_article")
public class Article implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("title")
    private String title;

    @TableField("description")
    private String description;

    @TableField("author")
    private String author;

    @TableField("content")
    private String content;

    @TableField("showcase")
    private String showcase;

    @TableField("browse_Num")
    private Integer browseNum;

    @TableField("praise_Num")
    private Integer praiseNum;

    @TableField("create_Time")
    private Date createTime;

    @TableField("update_Time")
    private Date updateTime;

    @TableField("is_deleted")
    private Integer isDeleted;

    @TableField("comment_no")
    private Integer commentNo;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShowcase() {
        return showcase;
    }

    public void setShowcase(String showcase) {
        this.showcase = showcase;
    }

    public Integer getBrowseNum() {
        return browseNum;
    }

    public void setBrowseNum(Integer browseNum) {
        this.browseNum = browseNum;
    }

    public Integer getPraiseNum() {
        return praiseNum;
    }

    public void setPraiseNum(Integer praiseNum) {
        this.praiseNum = praiseNum;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Integer getCommentNo() {
        return commentNo;
    }

    public void setCommentNo(Integer commentNo) {
        this.commentNo = commentNo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Article{" +
        "id=" + id +
        ", title=" + title +
        ", description=" + description +
        ", author=" + author +
        ", content=" + content +
        ", showcase=" + showcase +
        ", browseNum=" + browseNum +
        ", praiseNum=" + praiseNum +
        ", createTime=" + createTime +
        ", updateTime=" + updateTime +
        ", isDeleted=" + isDeleted +
        ", commentNo=" + commentNo +
        "}";
    }
}
