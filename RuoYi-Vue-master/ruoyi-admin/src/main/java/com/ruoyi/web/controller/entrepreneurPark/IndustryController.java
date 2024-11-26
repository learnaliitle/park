package com.ruoyi.web.controller.entrepreneurPark;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ruoyi.system.domain.entity.Industry;
import com.ruoyi.system.domain.vo.IndustryRankVO;
import com.ruoyi.system.service.entrepreneurPark.IndustryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "行业管理接口")
@RestController
@RequestMapping("/industries")
public class IndustryController {

    @Autowired
    private IndustryService industryService;

    @ApiOperation("新增行业")
    @PostMapping("/add")
    public boolean addIndustry(@RequestBody Industry industry) {
        return industryService.saveIndustry(industry);
    }

    @ApiOperation("更新行业信息")
    @PutMapping("/update")
    public boolean updateIndustry(@RequestBody Industry industry) {
        return industryService.updateIndustry(industry);
    }

    @ApiOperation("删除行业")
    @DeleteMapping("/delete/{industryId}")
    public boolean deleteIndustry(@PathVariable Integer industryId) {
        return industryService.deleteIndustry(industryId);
    }

    @ApiOperation("批量删除行业")
    @DeleteMapping("/deleteBatch")
    public boolean deleteBatch(@RequestBody List<Integer> industryIds) {
        return industryService.deleteBatch(industryIds);
    }

    @ApiOperation("分页查询行业")
    @GetMapping("/page")
    public IPage<Industry> pageIndustry(
            @RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "size", defaultValue = "10") int size) {
        return industryService.getIndustriesPage(page, size);
    }

    @GetMapping("/getIndustryById/{industryId}")
    @ApiOperation("通过ID获取行业信息")
    public Industry getIndustryById(@PathVariable("industryId") Integer industryId) {
        return industryService.getById(industryId);
    }


    @GetMapping("/ranking")
    @ApiOperation("所属行业占比排行")
    public List<IndustryRankVO> getIndustryRanking(@RequestParam int size) {
        return industryService.getIndustryRanking(size);
    }
}
