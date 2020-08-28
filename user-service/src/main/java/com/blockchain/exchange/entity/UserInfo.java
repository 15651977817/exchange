package com.blockchain.exchange.entity;


import lombok.Data;

/**
 * user_info
 *
 * @author
 */
@Data
public class UserInfo {

    private String nation;

    private String phone;

    private String realName;

    private String nickName;

    private int phoneFlag;

    private int line;

    private int level;

    private String loginPwd;

    private String tradePwd;

    private String inviterId;

    private String invitationCode;

    private int isCertification;

    private int safeGrade;

    private int brokerLevel;

    private String commission;
}
