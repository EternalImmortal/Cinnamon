package cn.weijoseph.cinnamon.Arithmetic4th.ObjectDemo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @author weirenjie
 * @date 2018/8/7
 */
public class UserLearnRecordSubmitDto implements Serializable {
    private static final long serialVersionUID = 8023919309877780782L;
    private String            targetId;

    private Integer           targetType;

    private Long              unitId;

    private Long              startTime;

    private Long              endTime;

    private Long              duration;

    private Long              memberId;

    private Integer           recordType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserLearnRecordSubmitDto that = (UserLearnRecordSubmitDto) o;
        return Objects.equals(targetId, that.targetId) &&
                Objects.equals(targetType, that.targetType) &&
                Objects.equals(unitId, that.unitId) &&
                Objects.equals(startTime, that.startTime) &&
                Objects.equals(endTime, that.endTime) &&
                Objects.equals(recordType, that.recordType);
    }

    @Override
    public int hashCode() {

        return Objects.hash(targetId, targetType, unitId, startTime, endTime, recordType);
    }

    public String getTargetId() {
        return targetId;
    }

    public void setTargetId(String targetId) {
        this.targetId = targetId;
    }

    public Integer getTargetType() {
        return targetType;
    }

    public void setTargetType(Integer targetType) {
        this.targetType = targetType;
    }

    public Long getUnitId() {
        return unitId;
    }

    public void setUnitId(Long unitId) {
        this.unitId = unitId;
    }

    public Long getStartTime() {
        return startTime;
    }

    public void setStartTime(Long startTime) {
        this.startTime = startTime;
    }

    public Long getEndTime() {
        return endTime;
    }

    public void setEndTime(Long endTime) {
        this.endTime = endTime;
    }

    public Long getDuration() {
        return duration;
    }

    public void setDuration(Long duration) {
        this.duration = duration;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public Integer getRecordType() {
        return recordType;
    }

    public void setRecordType(Integer recordType) {
        this.recordType = recordType;
    }

}
