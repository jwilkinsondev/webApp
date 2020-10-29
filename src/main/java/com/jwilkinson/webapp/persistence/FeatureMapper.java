package com.jwilkinson.webapp.persistence;

import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface FeatureMapper {

    @Select("select * from features where feature_id = #{featureID}")
    @Results({
            @Result(property = "featureID", column = "feature_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "clientID", column = "client_id"),
            @Result(property = "priority", column = "priority"),
            @Result(property = "targetDeliveryDate", column = "target_delivery_date"),
            @Result(property = "productArea", column = "product_area")
    })
    FeatureDBModel getFeature(@Param("featureID") Long featureID );

    @Select("select * from features")
    @Results({
            @Result(property = "featureID", column = "feature_id"),
            @Result(property = "title", column = "title"),
            @Result(property = "description", column = "description"),
            @Result(property = "clientID", column = "client_id"),
            @Result(property = "priority", column = "priority"),
            @Result(property = "targetDeliveryDate", column = "target_delivery_date"),
            @Result(property = "productArea", column = "product_area")
    })
    List<FeatureDBModel> getAllFeatures();

    @Insert("insert into features(feature_id, title, description, client_id, priority, targetDeliveryDate, productArea) values (#{featureID}, #{title}, #{description}, #{clientID}, #{priority}, #{targetDeliveryDate}, #{productArea})")
    void addFeature(FeatureDBModel featureDBModel);

    @Update("update features set feature_id = #{featureID}, title = #{title}, description = #{description}, client_id = #{clientID}, priority = #{priority}, targetDeliveryDate = #{targetDeliveryDate}, productArea = #{productArea} where feature_id = #{featureID}")
    int updateFeature(FeatureDBModel featureDBModel);

    @Delete("delete from features where feature_id = #{featureID}")
    void deleteFeature(@Param("featureID") Long featureID);
}
