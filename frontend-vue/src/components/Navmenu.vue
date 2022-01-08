<template>
  <div>
    <el-menu
        style="width: 200px; min-height: calc(100vh - 50px)"
        default-active="customer"
        class="el-menu-vertical-demo"
        router
        @open="handleOpen"
        @close="handleClose"
    >
      <el-menu-item index="customer" style="font-weight: bold" :route="{path: '/'}">Manage Customer Data</el-menu-item>
      <el-menu-item index="calculateageamount" style="font-weight: bold" :route="{path: '/calculateageamount'}">Minimum Age Amount</el-menu-item>
    </el-menu>
  </div>
</template>

<script>
export default {
  name: "Navmenu"
}
</script>

<style scoped>

</style>