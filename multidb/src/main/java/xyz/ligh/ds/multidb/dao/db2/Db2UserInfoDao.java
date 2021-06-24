package xyz.ligh.ds.multidb.dao.db2;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.ligh.ds.multidb.model.db1.Db1UserInfo;
import xyz.ligh.ds.multidb.model.db2.Db2UserInfo;

import java.util.List;

@Mapper
public interface Db2UserInfoDao {
    /**
     * 根据主键查找数据
     *
     * @param id 主键ID
     * @return 数据
     */
    public List<Db2UserInfo> selectById(@Param("id")Long id);
}
