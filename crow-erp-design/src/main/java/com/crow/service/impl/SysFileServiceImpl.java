package com.crow.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.crow.mapper.SysFileMapper;
import com.crow.model.SysFile;
import com.crow.model.SysFileVo;
import com.crow.service.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SysFileServiceImpl implements SysFileService {
    public SysFileMapper sysFileMapper;
    @Autowired
    private SysFileServiceImpl(SysFileMapper sysFileMapper){
        this.sysFileMapper=sysFileMapper;
    }
    @Override
    public Boolean addSysFile(SysFile sysFile) {
        return sysFileMapper.addSysFile(sysFile);
    }

    @Override
    public Boolean deleteSysFileByFid(Integer fid) {
        return sysFileMapper.deleteSysFileByFid(fid);
    }

    @Override
    public Boolean updateSysFile(SysFile sysFile) {
        return sysFileMapper.updateSysFile(sysFile);
    }

    @Override
    public SysFile selectSysFileByFid(Integer fid) {
        return sysFileMapper.selectSysFileByFid(fid);
    }

    @Override
    public IPage<SysFile> queryPageSysFile(Integer size,Integer sizePage) {
        Page<SysFile> page = new Page<>(size,sizePage);
        return sysFileMapper.queryPageSysFile(page);
    }

    @Override
    public Boolean examineSysFile(SysFile sysFile) {
        return sysFileMapper.examineSysFile(sysFile);
    }

    @Override
    public List<SysFile> queryFileList() {
        return sysFileMapper.queryFileList();
    }

    @Override
    public IPage<SysFile> querySysFileVo(Integer size, Integer sizePage, SysFileVo sysFileVo) {
        if (size <= 0){
            size = 1;
        }
        Page page = new Page<>(size,sizePage);
        IPage<SysFile> iPage = sysFileMapper.querySysFileVo(page, sysFileVo);
        return iPage;
    }

    @Override
    public Boolean updateFile(SysFile sysFile) {
        return sysFileMapper.updateFile(sysFile);
    }

    @Override
    public Boolean updateCheckTag(Integer fid) {
        return sysFileMapper.updateCheckTag(fid);
    }
}
