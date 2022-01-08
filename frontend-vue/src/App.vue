<template>
  <div>
    <Header />
    <div style="display: flex">
      <Navmenu />
      <router-view style="flex: 1"/>
    </div>
  </div>
</template>

<style>

</style>
<script>
  import Header from "./components/Header";
  import Navmenu from "./components/Navmenu";

  export default {
    name: "Layout",
    components: {
      Header,
      Navmenu
  }
}
</script>
