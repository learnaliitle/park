package com.ruoyi.web.controller.entrepreneurPark;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.system.domain.DTO.ApprovalDTO;
import com.ruoyi.system.domain.entity.Approval;
import com.ruoyi.system.domain.vo.ApprovalVO;
import com.ruoyi.system.service.entrepreneurPark.ApprovalService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "审批管理")
@RestController
@RequestMapping("/api/approval")
public class ApprovalController {

    @Autowired
    private ApprovalService approvalService;

    @ApiOperation(value = "获取审批分页数据", notes = "根据页码和每页数据量获取审批分页数据")
    @GetMapping("/list")
    public Page<ApprovalVO> getApprovalPage(
            @ApiParam(value = "页码", required = true) @RequestParam int pageNum,
            @ApiParam(value = "每页数量", required = true) @RequestParam int pageSize) {
        return approvalService.getApprovalPage(pageNum, pageSize);
    }

    @ApiOperation(value = "新增审批", notes = "添加新的审批记录")
    @PostMapping("/add")
    public boolean addApproval(@RequestBody ApprovalDTO approvalDTO) {
        return approvalService.addApproval(approvalDTO);  // 使用 MyBatis-Plus 的 save 方法
    }

    @ApiOperation(value = "更新审批", notes = "更新已有的审批记录")
    @PutMapping("/update")
    public boolean updateApproval(@RequestBody Approval approval) {
        return approvalService.updateById(approval);  // 使用 MyBatis-Plus 的 updateById 方法
    }

    @ApiOperation(value = "删除审批", notes = "根据ID删除审批")
    @DeleteMapping("/delete/{id}")
    public boolean deleteApproval(@PathVariable Integer id) {
        return approvalService.removeById(id);  // 使用 MyBatis-Plus 的 removeById 方法
    }

    /**
     * 根据approvalId查询审批信息
     * @param approvalId
     * @return
     */
    @GetMapping("/get/{approvalId}")
    public Approval getApprovalById(@PathVariable Integer approvalId) {
        return approvalService.getById(approvalId);  // 使用 MyBatis-Plus 的 getById 方法
    }

    @ApiOperation(value = "批量删除审批", notes = "根据ID列表批量删除审批")
    @DeleteMapping("/delete-batch")
    public boolean deleteApprovalBatch(@RequestBody List<Integer> ids) {
        return approvalService.removeByIds(ids);  // 使用 MyBatis-Plus 的 removeByIds 方法
    }

    @ApiOperation(value = "获取审批记录申请分页数据", notes = "根据页码和每页数据量获取部门管理员申请分页数据")
    @GetMapping("/list1")
    public Page<ApprovalVO> getApplicationPage1(
            @ApiParam(value = "页码", required = true) @RequestParam int pageNum,
            @ApiParam(value = "每页数量", required = true) @RequestParam int pageSize) {
        LoginUser loginUser = SecurityUtils.getLoginUser();
        return approvalService.getPage1(pageNum, pageSize, loginUser);
    }
}
