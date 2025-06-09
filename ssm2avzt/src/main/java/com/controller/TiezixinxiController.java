package com.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.TiezixinxiEntity;
import com.entity.view.TiezixinxiView;

import com.service.TiezixinxiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.MD5Util;
import com.utils.MPUtil;
import com.utils.CommonUtil;


/**
 * 帖子信息
 * 后端接口
 * @author 
 * @email 
 * @date 2021-04-17 14:10:17
 */
@RestController
@RequestMapping("/tiezixinxi")
public class TiezixinxiController {
    @Autowired
    private TiezixinxiService tiezixinxiService;
    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,TiezixinxiEntity tiezixinxi, 
		HttpServletRequest request){

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			tiezixinxi.setYonghuming((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<TiezixinxiEntity> ew = new EntityWrapper<TiezixinxiEntity>();
		PageUtils page = tiezixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tiezixinxi), params), params));
        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,TiezixinxiEntity tiezixinxi, HttpServletRequest request){
        EntityWrapper<TiezixinxiEntity> ew = new EntityWrapper<TiezixinxiEntity>();
		PageUtils page = tiezixinxiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, tiezixinxi), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( TiezixinxiEntity tiezixinxi){
       	EntityWrapper<TiezixinxiEntity> ew = new EntityWrapper<TiezixinxiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( tiezixinxi, "tiezixinxi")); 
        return R.ok().put("data", tiezixinxiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(TiezixinxiEntity tiezixinxi){
        EntityWrapper< TiezixinxiEntity> ew = new EntityWrapper< TiezixinxiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( tiezixinxi, "tiezixinxi")); 
		TiezixinxiView tiezixinxiView =  tiezixinxiService.selectView(ew);
		return R.ok("查询帖子信息成功").put("data", tiezixinxiView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        TiezixinxiEntity tiezixinxi = tiezixinxiService.selectById(id);
        return R.ok().put("data", tiezixinxi);
    }

    /**
     * 前端详情
     */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        TiezixinxiEntity tiezixinxi = tiezixinxiService.selectById(id);
        return R.ok().put("data", tiezixinxi);
    }
    


    /**
     * 赞或踩
     */
    @RequestMapping("/thumbsup/{id}")
    public R thumbsup(@PathVariable("id") String id,String type){
        TiezixinxiEntity tiezixinxi = tiezixinxiService.selectById(id);
        if(type.equals("1")) {
        	tiezixinxi.setThumbsupnum(tiezixinxi.getThumbsupnum()+1);
        } else {
        	tiezixinxi.setCrazilynum(tiezixinxi.getCrazilynum()+1);
        }
        tiezixinxiService.updateById(tiezixinxi);
        return R.ok();
    }

    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody TiezixinxiEntity tiezixinxi, HttpServletRequest request){
    	tiezixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tiezixinxi);

        tiezixinxiService.insert(tiezixinxi);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody TiezixinxiEntity tiezixinxi, HttpServletRequest request){
    	tiezixinxi.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(tiezixinxi);

        tiezixinxiService.insert(tiezixinxi);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody TiezixinxiEntity tiezixinxi, HttpServletRequest request){
        //ValidatorUtils.validateEntity(tiezixinxi);
        tiezixinxiService.updateById(tiezixinxi);//全部更新
        return R.ok();
    }
    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        tiezixinxiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
    /**
     * 提醒接口
     */
	@RequestMapping("/remind/{columnName}/{type}")
	public R remindCount(@PathVariable("columnName") String columnName, HttpServletRequest request, 
						 @PathVariable("type") String type,@RequestParam Map<String, Object> map) {
		map.put("column", columnName);
		map.put("type", type);
		
		if(type.equals("2")) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Calendar c = Calendar.getInstance();
			Date remindStartDate = null;
			Date remindEndDate = null;
			if(map.get("remindstart")!=null) {
				Integer remindStart = Integer.parseInt(map.get("remindstart").toString());
				c.setTime(new Date()); 
				c.add(Calendar.DAY_OF_MONTH,remindStart);
				remindStartDate = c.getTime();
				map.put("remindstart", sdf.format(remindStartDate));
			}
			if(map.get("remindend")!=null) {
				Integer remindEnd = Integer.parseInt(map.get("remindend").toString());
				c.setTime(new Date());
				c.add(Calendar.DAY_OF_MONTH,remindEnd);
				remindEndDate = c.getTime();
				map.put("remindend", sdf.format(remindEndDate));
			}
		}
		
		Wrapper<TiezixinxiEntity> wrapper = new EntityWrapper<TiezixinxiEntity>();
		if(map.get("remindstart")!=null) {
			wrapper.ge(columnName, map.get("remindstart"));
		}
		if(map.get("remindend")!=null) {
			wrapper.le(columnName, map.get("remindend"));
		}

		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wrapper.eq("yonghuming", (String)request.getSession().getAttribute("username"));
		}

		int count = tiezixinxiService.selectCount(wrapper);
		return R.ok().put("count", count);
	}
	


}
