<script setup>

</script>

<template>
  <div>我是记录者</div>
  <div>
    <el-main>
      <div style="padding: 10px 0">
        <el-input style="width: 200px;" placeholder="根据店名查询" @keyup.enter="search"
                  v-model="name"></el-input>
        <el-button type="primary" style="margin-left: 5px;" @click="search">搜索门店</el-button>
        <el-button type="primary" @click="addDoor">新增门店</el-button>
        <el-dialog v-model="dialogFormVisibles" title="门店信息" width="30%" @close="closeDialogs">
          <el-form :model="newForm">
            <el-form-item label="店名:">
              <el-input v-model="newForm.name" autocomplete="off"/>
            </el-form-item>
            <el-form-item label="电话:">
              <el-input v-model="newForm.tel" autocomplete="off"/>
            </el-form-item>
            <el-form-item label="地址:">
              <el-input v-model="newForm.addr" autocomplete="off"/>
            </el-form-item>

          </el-form>
          <span class="dialog-footer">
                       <el-button @click="cancel">取消</el-button>
                       <el-button type="primary" @click="insertDoor">
                         确认
                            </el-button>
                        </span>

        </el-dialog>
      </div>

      <el-scrollbar>
        <el-table :data="tableData.data" border stripe @selection-change="handleSelectionChange">

          <el-table-column prop="doorId" label="ID" width="100" style="height: 20px;"/>
          <el-table-column prop="name" label="店名" width="100"/>
          <el-table-column prop="tel" label="电话" width="100"/>
          <el-table-column prop="addr" label="地址" width="100"/>
          <el-table-column prop="control" label="操作">
            <template #default="{row}">
              <el-button type="success" @click="modify(row)">修改</el-button>
              <el-popconfirm
                  width="220"
                  confirm-button-text="确定"
                  cancel-button-text="不用了"
                  :icon="InfoFilled"
                  icon-color="red"
                  title="确定删除这段内容吗?"
                  @confirm="deleteDoor(row)"
                  router
              >
                <template #reference>
                  <el-button type="danger">删除</el-button>
                </template>
              </el-popconfirm>

            </template>
          </el-table-column>
        </el-table>
        <div style="padding: 10px 0">
          <el-pagination
              @size-change="handleSizeChange"
              @current-change="handleCurrentChange"
              v-model:current-page="pageNum"
              v-model:page-size="pageSize"
              :page-sizes="[3,5]"
              layout="total, sizes, prev, pager, next, jumper"
              :total="total"

          />
        </div>
        <el-dialog v-model="dialogFormVisible" title="门店信息" width="30%" @close="closeDialog">
          <el-form :ref="refForm" :model="form">
            <el-form-item label="店名:">
              <el-input v-model="form.name" autocomplete="off"/>
            </el-form-item>
            <el-form-item label="电话:">
              <el-input v-model="form.tel" autocomplete="off"/>
            </el-form-item>
            <el-form-item label="地址:">
              <el-input v-model="form.addr" autocomplete="off"/>
            </el-form-item>

          </el-form>
          <span class="dialog-footer">
                       <el-button @click="cancel">取消</el-button>
                       <el-button type="primary" @click="save">
                         确认
                            </el-button>
                        </span>
        </el-dialog>
      </el-scrollbar>

    </el-main>
  </div>
</template>

<style scoped>

</style>