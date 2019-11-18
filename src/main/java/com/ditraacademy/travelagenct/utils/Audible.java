package com.ditraacademy.travelagenct.utils;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.util.Date;
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public class Audible<U> {

    @CreatedDate
    private Date CreatedDate;

    @CreatedBy
    private U  CreatedBy;

    @LastModifiedDate
    private Date LastModifiedDate;

    @LastModifiedBy
    private U LastModifiedBy;

}
