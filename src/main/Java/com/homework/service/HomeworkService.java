package com.homework.service;

import com.homework.DBConnection;
import com.homework.Keyutils;
import com.homework.entity.*;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomeworkService {
    Connection conn;
    DBConnection jdbc = new DBConnection();

    public boolean register(User user){
        boolean flag = false;
        boolean isExist = login(user);
        if(!isExist){
            conn = jdbc.connect();
            String sql = "INSERT INTO user(id,name,pwd,sex,status) VALUES(?,?,?,?,?)";
            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1, Keyutils.genUniqueKey());
                pstmt.setString(2,user.getName());
                pstmt.setString(3, user.getPwd());
                pstmt.setString(4, user.getSex());
                pstmt.setString(5, user.getStatus());
                int rs = pstmt.executeUpdate();
                if(rs >= 1){
                    flag = true;
                }
                pstmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(conn != null){
                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        else{
            System.out.println("注册失败");
        }
        return flag;
    }





    public boolean login(User user){
        boolean flag = false;
        conn = jdbc.connect();
        String sql = "SELECT * FROM user WHERE name=? AND pwd=? AND status=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,user.getName());
            pstmt.setString(2,user.getPwd());
            pstmt.setString(3,user.getStatus());
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                flag = true;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }


    /**
     * 在数据库中查询名字是否重复
     * @param name
     * @return
     */
    public boolean findByName(String name){
        boolean flag = false;
        conn = jdbc.connect();
        String sql = "SELECT * FROM user WHERE name=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,name);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                flag = true;
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return flag;
    }











    /**
     * genjuopen_date查询作业，目前用于今日竞赛
     * @return
     */
    public List<HomeworkMaster> getHomeworkmasterByDateAndType(long searchDate, String type){
        List<HomeworkMaster> homeworkmasterArrayList = new ArrayList<HomeworkMaster>();
        conn = jdbc.connect();
        String sql = "SELECT * FROM homeworkmaster WHERE open_date=? AND type=?;";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            Date sdate = new Date(searchDate);
            pstmt.setDate(1,sdate);
            pstmt.setString(2,type);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                HomeworkMaster homeworkmaster = new HomeworkMaster();
                homeworkmaster.setId(rs.getString("id"));
                homeworkmaster.setOpwen_date(rs.getDate("open_date"));
                homeworkmaster.setTitle(rs.getString("title"));
                homeworkmaster.setType(rs.getString("type"));
                homeworkmaster.setUpdate_time(rs.getTime("update_time"));
                homeworkmasterArrayList.add(homeworkmaster);
            }
            rs.close();
            pstmt.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return homeworkmasterArrayList;
    }


    public List<HomeworkDetail> getHomeworkDetailByMasterId(String mid){
        List<HomeworkDetail> homeworkDetailArrayList = new ArrayList<HomeworkDetail>();
        conn = jdbc.connect();
        String sql = "SELECT * FROM homeworkdetail WHERE master_id=?;";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,mid);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                HomeworkDetail homeworkDetail = new HomeworkDetail();
                homeworkDetail.setContent(rs.getString("content"));
                homeworkDetail.setId(rs.getString("id"));
                homeworkDetail.setMaster_id(rs.getString("master_id"));
                homeworkDetail.setUpdate_time(rs.getTime("update_time"));
                homeworkDetailArrayList.add(homeworkDetail);
            }
            rs.close();
            pstmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return homeworkDetailArrayList;
    }


    /**
     *将homeworkDetailId插入homeworkdetail表中的id列
     *将homeworkMasterId插入homeworkdetail表中的master_id列
     *将requirement插入homeworkdetail表中的content列
     * @param homeworkDetailId
     * @param homeworkMasterId
     * @param requirment
     * @return
     */



    public boolean insertToHomeworkDetail(String homeworkDetailId, String homeworkMasterId, String requirment){
        boolean flag = false;
        Connection conn = jdbc.connect();
        String sql = "INSERT INTO homeworkdetail(id,master_id,content)VALUES(?,?,?);";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,homeworkDetailId);
            pstmt.setString(2,homeworkMasterId);
            pstmt.setString(3,requirment);
            if(pstmt.executeUpdate() >= 1){
                flag = true;
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }



    public boolean insertToHomeworkMaster(String homeworkMasterId, String title, String type, Date openDate){
        boolean flag = false;
        Connection conn = jdbc.connect();
        String sql = "INSERT INTO homeworkmaster(id,title,type,open_date)VALUES(?,?,?,?);";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,homeworkMasterId);
            pstmt.setString(2,title);
            pstmt.setString(3,type);
            pstmt.setDate(4,openDate);
            if(pstmt.executeUpdate() >= 1){
                flag = true;
            }
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return flag;
    }



    public List<HomeworkIsSubmitVo> getIsSubmit(String homeworkMasterId){
        List<HomeworkIsSubmitVo> homeworkIsSubmitVoList = new ArrayList<HomeworkIsSubmitVo>();
        conn = jdbc.connect();
        String sql = "select u.name, uh.homeworkmaster_id, u.status  from user u left join user_homework uh on(u.id=uh.user_id and uh.homeworkmaster_id = ?);";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,homeworkMasterId);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                HomeworkIsSubmitVo hisvo = new HomeworkIsSubmitVo();
                hisvo.setUserName(rs.getString("name"));
                hisvo.setStatus(rs.getString("status"));
                if(rs.getString("homeworkmaster_id") != null){
                    hisvo.setIsSubmit("已提交");
                }
                else if(rs.getString("homeworkmaster_id") == null){
                    hisvo.setIsSubmit("未提交");
                }
                homeworkIsSubmitVoList.add(hisvo);

            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return homeworkIsSubmitVoList;
    }





    public  List<HomeworkSortVo> sort(String type){
        List<HomeworkSortVo> homeworkSortVoList = new ArrayList<HomeworkSortVo>();
        conn = jdbc.connect();
        if("竞赛".equals(type) || "结对".equals(type)){
            String sql="select u.name,count(t.homeworkmaster_id )" +
                    "from user u left join " +
                    "(select u.id,u.name, uh.homeworkmaster_id " +
                    "from user u left join " +
                    "user_homework uh on u.id=uh.user_id " +
                    "left join homeworkmaster h on uh.homeworkmaster_id=h.id " +
                    "where h.`type`=?) t on t.id=u.id group by u.id" +
                    " order by count(t.homeworkmaster_id) desc;";

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setString(1,type);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    HomeworkSortVo hsv = new HomeworkSortVo();
                    hsv.setCount(rs.getInt("count(t.homeworkmaster_id )"));
                    hsv.setName(rs.getString("name"));
                    homeworkSortVoList.add(hsv);
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(conn!=null){
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        if("全部".equals(type)){
            String sql="select u.name,count(t.homeworkmaster_id )" +
                    "from user u left join " +
                    "(select u.id,u.name, uh.homeworkmaster_id " +
                    "from user u left join " +
                    "user_homework uh on u.id=uh.user_id " +
                    "left join homeworkmaster h on uh.homeworkmaster_id=h.id) t " +
                    "on t.id=u.id group by u.id" +
                    " order by count(t.homeworkmaster_id) desc;";

            try {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                ResultSet rs = pstmt.executeQuery();
                while(rs.next()){
                    HomeworkSortVo hsv = new HomeworkSortVo();
                    hsv.setCount(rs.getInt("count(t.homeworkmaster_id )"));
                    hsv.setName(rs.getString("name"));
                    homeworkSortVoList.add(hsv);
                }
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                try {
                    if(conn!=null){
                        conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return homeworkSortVoList;
    }



    public List<HomeworkContentVo> getContentByMasterId(String mid){
        List<HomeworkContentVo> homeworkContentVoList = new ArrayList<HomeworkContentVo>();
        conn = jdbc.connect();
        String sql = "SELECT content,update_time FROM homeworkdetail WHERE master_id=?";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,mid);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                HomeworkContentVo homeworkContentVo = new HomeworkContentVo();
                homeworkContentVo.setContent(rs.getString("content"));
                homeworkContentVo.setUpdateTime(rs.getTimestamp("update_time"));
                System.out.println(rs.getTimestamp("update_time").getTime());
                homeworkContentVoList.add(homeworkContentVo);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }


        return homeworkContentVoList;
    }




    public List<HomeworkMaster> getAllHomeworkMaster(){
        List<HomeworkMaster> homeworkMasterList = new ArrayList<HomeworkMaster>();
        conn = jdbc.connect();
        String sql = "SELECT * FROM homeworkmaster;";
        try {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while(rs.next()){
                HomeworkMaster homeworkMaster = new HomeworkMaster();
                homeworkMaster.setId(rs.getString("id"));
                homeworkMaster.setOpwen_date(rs.getDate("open_date"));
                homeworkMaster.setType(rs.getString("type"));
                homeworkMaster.setTitle(rs.getString("title"));
                homeworkMaster.setUpdate_time(rs.getTime("update_time"));
                homeworkMasterList.add(homeworkMaster);
            }
            rs.close();
            pstmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            if(conn != null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return homeworkMasterList;
    }
}
