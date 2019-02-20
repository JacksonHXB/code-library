package com.hxb.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import com.hxb.bean.Department;

//指定这是一个操作数据库的mapper
//@Mapper   可以使用MapperScan批量扫描所有的mapper接口(主配置类，或MyBatis类上) @MapperScan(value="com.hxb.mapper")   //扫描该包下面的所有映射文件
public interface DepartmentMapper {
	//根据ID查询部门
	@Select("select * from tb_department where id=#{id}")
	public Department getDeptById(Integer id);
	
	//根据ID删除部门
	@Delete("delete from tb_department where id=#{id}")
	public int deleteDeptById(Integer id);
	
	//插入部门
	@Options(useGeneratedKeys=true,keyProperty="id")
	@Insert("insert into tb_department(departmentName) values(#{departmentName})")
	public int insertDept(Department department);
	
	//更新部门
	@Update("update tb_department set departmentName=#{departmentName} where id=#{id}")
	public int updateDept(Department department);
}







































