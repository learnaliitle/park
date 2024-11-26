import request from '@/utils/request'

// 查询地域列表
export function pageIndustry(query) {
  return request({
    url: '/industries/page',
    method: 'get',
    params: query
  })
}


//根据industryId删除地域信息
export function deleteIndustry(industryId) {
  return request({
    url: `/industries/delete/${industryId}`,
    method: 'delete'
  })
}


// 新增行业
export function addIndustry(data) {
  return request({
    url: '/industries/add',
    method: 'post',
    data: data
  })
}




//通过ID获取行业信息
export function getIndustryById(industryId) {
  return request({
    url: `/industries/getIndustryById/${industryId}`,
    method: 'get',
  })
}


//更新行业信息
export function updateIndustry(data) {
  return request({
    url: '/industries/update',
    method: 'put',
    data: data
  })
}


