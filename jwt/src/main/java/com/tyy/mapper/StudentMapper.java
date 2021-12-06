package com.tyy.mapper;

import com.tyy.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author tyy
 * @since 2021-06-07
 */
@Mapper
public interface StudentMapper extends BaseMapper<Student> {

}
