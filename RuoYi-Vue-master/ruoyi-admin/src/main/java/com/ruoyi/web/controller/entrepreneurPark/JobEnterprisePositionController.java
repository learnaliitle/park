package com.ruoyi.web.controller.entrepreneurPark;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.system.domain.entity.JobEnterprisePosition;
import com.ruoyi.system.domain.vo.JobEnterprisePositionVO;
import com.ruoyi.system.service.entrepreneurPark.JobEnterprisePositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Api(tags = "企业与岗位关联接口")
@RestController
@RequestMapping("/api/job-enterprise-positions")
public class JobEnterprisePositionController {

    @Autowired
    private JobEnterprisePositionService jobEnterprisePositionService;

    @ApiOperation(value = "获取企业与岗位关联列表（分页）")
    @GetMapping("/list")
    public Page<JobEnterprisePositionVO> getJobEnterprisePositionsPage(
            @ApiParam(value = "页码", required = true) @RequestParam int pageNum,
            @ApiParam(value = "每页大小", required = true) @RequestParam int pageSize) {
        return jobEnterprisePositionService.getJobEnterprisePositionsPage(pageNum, pageSize);
    }

    @ApiOperation(value = "根据ID删除企业与岗位关联")
    @DeleteMapping("/{id}")
    public boolean deleteJobEnterprisePositionById(
            @ApiParam(value = "企业岗位关联ID", required = true) @PathVariable Integer id) {
        return jobEnterprisePositionService.removeById(id);
    }

    @ApiOperation(value = "批量删除企业与岗位关联")
    @DeleteMapping("/batch")
    public boolean deleteJobEnterprisePositions(
            @ApiParam(value = "企业岗位关联ID列表", required = true) @RequestBody List<Integer> enterpriseJobIds) {
        return jobEnterprisePositionService.removeBatchByIds(enterpriseJobIds);
    }

    @ApiOperation(value = "添加企业与岗位关联")
    @PostMapping
    public boolean addJobEnterprisePosition(@Valid @RequestBody JobEnterprisePosition jobEnterprisePosition) {
        return jobEnterprisePositionService.save(jobEnterprisePosition);
    }

    @ApiOperation(value = "更新企业与岗位关联")
    @PutMapping
    public boolean updateJobEnterprisePosition(@Valid @RequestBody JobEnterprisePosition jobEnterprisePosition) {
        return jobEnterprisePositionService.updateById(jobEnterprisePosition);
    }
}