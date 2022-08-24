package com.smf.wqphd.controller;


import com.smf.wqphd.bean.Comm;
import com.smf.wqphd.bean.Mate;
import com.smf.wqphd.bean.Pager;
import com.smf.wqphd.bean.ResMsg;
import com.smf.wqphd.service.CommService;
import com.smf.wqphd.vo.AddVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

@Controller
public class CommControler {
    @Autowired
    CommService service;

    /**
     * @param page
     * @param size easyui传递分页大小用的参数名是rows
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Pager<Comm> findList(@RequestParam(name = "page", defaultValue = "1") Integer page,
                                @RequestParam(name = "rows", defaultValue = "15") Integer size) {
        Pager<Comm> param = new Pager<Comm>(page, size);
        List<Comm> list = service.findListByPager(param);
        int total = service.findTotalByPager(param);
        // easyui的grid table解析数据时，json格式的名称叫rows
        param.setRows(list);
        param.setTotal(total);
        return param;
    }

    @RequestMapping("/search")
    @ResponseBody
    public Pager<Comm> search(String d_name,String r_name){
        System.out.println(d_name+r_name);
        //ResMsg msg=new ResMsg();
       // Comm comm=service.selectBydr(d_name,r_name);
        Pager<Comm> res=new Pager<>();
        List<Comm> list= Collections.singletonList(service.selectBydr(d_name, r_name));
       res.setRows(list);
        //System.out.println(comm);
      //  msg.setResult(comm);
        return res;
    }


    @RequestMapping("/add")
    @ResponseBody
    public ResMsg add(Comm comm){
        System.out.println(comm);
        boolean jud=service.add(comm);
        System.out.println(jud);
        ResMsg msg=new ResMsg();
        if(jud){
            msg.setErrcode("0");
            msg.setErrmsg("添加成功");
        }else{
            msg.setErrcode("1");
            msg.setErrmsg("添加失败");
        }
        return msg;
    }

    @RequestMapping("/delete")
    @ResponseBody
    public ResMsg delete(int a_Id){
        Comm com=new Comm();
        ResMsg msg= new ResMsg();
        com.setA_Id(a_Id);
        //System.out.println(a_Id);
        boolean jud=service.delete(com);
        if(jud){
            msg.setErrcode("0");
            msg.setErrmsg("删除成功");
        }else{
            msg.setErrcode("1");
            msg.setErrmsg("删除失败");
        }
        return msg;
    }


    @RequestMapping("/edit")
    @ResponseBody
    public ResMsg edit(Comm comm){
        ResMsg msg=new ResMsg();
        //System.out.println(comm);
        //Comm comm1=new Comm();
        boolean jud=service.edit(comm);
        if(jud){
            msg.setErrcode("0");
            msg.setErrmsg("修改成功");
        }else{
            msg.setErrcode("1");
            msg.setErrmsg("修改失败");
        }
        return msg;
    }


    @RequestMapping("/selectmq")
    @ResponseBody
    public Pager<Mate> selectmq(int a_id){
        Pager<Mate> res =new Pager<Mate>();
        Mate mate=service.selMqById(a_id);
        res.setRows(Collections.singletonList(mate));
        System.out.println(mate);
        return res;
    }

    @RequestMapping("/addVoList")
    @ResponseBody
    public List<AddVo> lst(){
        return service.selectTotal();
    }

}
