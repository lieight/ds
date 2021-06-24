package xyz.ligh.ds.multidb.dao.db1;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.ligh.ds.multidb.model.db1.Db1UserInfo;

import java.util.List;

@Mapper
public interface Db1UserInfoDao {
    /**
     * 根据主键查找数据
     *
     * @param id 主键ID
     * @return 数据
     */
    public List<Db1UserInfo> selectById(@Param("id")Long id);
}
