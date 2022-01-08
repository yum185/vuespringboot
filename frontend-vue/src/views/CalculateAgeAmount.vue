<template>
  <div class="block" style="padding: 100px">

    <div style="margin-bottom: 20px">
      <el-form :model="yearform"  >
        <el-form-item prop="startyear" label="Start Year">
          <el-date-picker v-model="yearform.startyear" type="year"  format="YYYY" value-format="YYYY" placeholder="Pick a start year">
          </el-date-picker>
        </el-form-item>
        <el-form-item prop="endyear" label="End Year">
          <el-date-picker v-model="yearform.endyear" type="year" format="YYYY" value-format="YYYY" placeholder="Pick a end year">
          </el-date-picker>
        </el-form-item>
      </el-form>
      <el-button type="primary" style="margin-left: 3px" @click="calculateAmount()">Calculate Age Mount</el-button>
    </div>
    <div> <div style="with: 200px;font-size: 20px">Minimum age mount : {{result}}</div>

    </div>
  </div>


  <div>

  </div>
</template>

<script>
import request from "@/utils/request";


export default {
  name: "CalculateAgeAmount",
  data(){
    return{
      result:'',
      yearform: {}
    }
  },
  methods: {
    calculateAmount(){
      console.log(this.yearform.startyear)
      request.get("/calculateageamount", {
        params:{
          startTime: this.yearform.startyear,
          endTime: this.yearform.endyear
        }
      }).then(res => {
        if(res.code != 0){
          this.result = ""
        } else {
          this.result = res.data
        }
      })
    }
  }
}
</script>

<style scoped>

</style>