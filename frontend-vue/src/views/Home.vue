<template>
  <div style="padding: 10px">
    <div style="margin: 10px 0">
      <el-button type="primary" @click="addCustomer">Add Customer</el-button>
    </div>
    <div style="margin: 10px 0">
      <el-input v-model="searchName" placeholder="Customer Name" style="width: 20%" clearable></el-input>
      <el-input v-model="searchAge" placeholder="Age" style="width: 20%" clearable></el-input>
      <el-button type="primary" style="margin-left: 3px" @click="loadCustomer">Search</el-button>
    </div>
    <el-table :data="tableData" border stripe style="width: 100%">
      <el-table-column prop="id" label="ID" sortable/>
      <el-table-column prop="name" label="Name"/>
      <el-table-column prop="age" label="Age"/>
      <el-table-column prop="birthdate" label="Birthday"/>
      <el-table-column prop="cell" label="Cellphone"/>
      <el-table-column prop="school" label="School"/>
      <el-table-column prop="email" label="email"/>
      <el-table-column prop="address" label="Address"/>
      <el-table-column fixed="right" label="Operations">
        <template #default="scope">
          <el-button @click="handleEdit(scope.row)">Edit</el-button>
          <el-popconfirm title="Confirm to delete?" @confirm="handleDelete(scope.row.id)">
            <template #reference>
              <el-button type="danger" >Delete</el-button>
            </template>
          </el-popconfirm>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px">
      <el-pagination
          v-model:currentPage="currentPage"
          :page-sizes="[5, 10]"
          :page-size="5"
          layout="total, sizes, prev, pager, next, jumper"
          :default-page-size="pageSize"
          :total="totalElement"
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
      >
      </el-pagination>
      <el-dialog v-model="dialogFormVisible" title="Add a customer">
        <el-form :model="form" label-width="150px">
          <el-form-item label="Customer Name">
            <el-input v-model="form.name" style="width: 50%"></el-input>
          </el-form-item>
          <el-form-item label="Birthday"
                        style="width: 50%">
            <el-date-picker
                v-model="form.birthdate"
                type="date"
                placeholder="Birthday"
                value-format="YYYY-MM-DD"
            ></el-date-picker>
          </el-form-item>
          <el-form-item label="Cellphone">
            <el-input v-model="form.cell" style="width: 50%"></el-input>
          </el-form-item>
          <el-form-item label="School">
            <el-input v-model="form.school" style="width: 50%"></el-input>
          </el-form-item>
          <el-form-item label="Email address">
            <el-input v-model="form.email" style="width: 50%"></el-input>
          </el-form-item>
          <el-form-item label="Address">
            <el-input v-model="form.address" type="textarea" style="width: 50%"></el-input>
          </el-form-item>
        </el-form>
        <template #footer>
      <span class="dialog-footer">
        <el-button @click="dialogFormVisible = false">Cancel</el-button>
        <el-button type="primary" @click="saveCustomer"
        >Submit</el-button
        >
      </span>
        </template>
      </el-dialog>
    </div>
  </div>
</template>

<script>
// @ is an alias to /src

import request from "@/utils/request";

export default {
  name: 'Home',
  components: {},
  data() {
    return {
      dialogFormVisible: false,
      form: {},
      searchName: '',
      searchAge: '',
      age: "",
      currentPage: 1,
      totalElement:10,
      pageSize: 5,
      tableData: []
    }
  },
  created(){
    this.loadCustomer()
  },
  methods: {
    addCustomer() {
      this.dialogFormVisible = true
      this.form={}
    },
    loadCustomer(){
      request.get("/customer", {
        params:{
          pageNumber: this.currentPage,
          pageSize: this.pageSize,
          searchName: this.searchName,
          searchAge: this.searchAge
        }
      }).then(res => {
        console.log(res)
        this.tableData = res.data.records
        this.pageSize = res.data.currentSize
        this.totalElement = res.data.totalElements
      })
    },
    saveCustomer() {
      if(this.form.id) {
        request.put("/customer",this.form).then(res => {
          console.log(res)
          if(res.code == 0){
            this.$message({
              type:"success",
              message:"Update successfully!"
            })
            this.loadCustomer()
            this.dialogFormVisible=false
          } else {
            this.$message({
              type:"error",
              message:res.msg
            })
          }

        })
      } else {
        request.post("/customer",this.form).then(res => {
          console.log(res)
          if(res.code == 0){
            this.$message({
              type:"success",
              message:"Add successfully!"
            })
            this.loadCustomer()
            this.dialogFormVisible=false
          } else {
            this.$message({
              type:"error",
              message:res.msg
            })
          }
        })
      }

    },
    handleEdit(row) {
      this.form = JSON.parse(JSON.stringify(row))
      this.dialogFormVisible = true
    },
    handleDelete(id) {
     request.delete("/customer/"+id).then( res => {
       if(res.code == 0){
         this.$message({
           type:"success",
           message:"Delete successfully!"
         })
       } else {
         this.$message({
           type:"error",
           message:res.msg
         })
       }
       this.loadCustomer()
     })

    },
    handleSizeChange(val) {

      this.pageSize = val
      console.log(this.totalElement)
      this.loadCustomer()
    },
    handleCurrentChange(pageNum) {
      this.currentPage = pageNum
      console.log(this.currentPage)
      this.loadCustomer()
    },
  }
}
</script>
