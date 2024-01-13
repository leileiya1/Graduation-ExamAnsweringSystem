<script setup>
import CarouselChart from "@/views/welcome/CarouselChart.vue";
</script>

<template>

  <div class="total-card">
    <div class="left-card">
      <CarouselChart class="carousel-container "/>
    </div>
  <div class="right-card">
    <router-view v-slot="{ Component }">
      <transition mode="out-in" name="el-fade-in-linear">
        <component :is="Component" style="height: 100%;"/>
      </transition>
    </router-view>
  </div>
  </div>
</template>

<style scoped>

.carousel-container{
  width: 100%; /* 或其他具体尺寸 */
  height: 500px; /* 或其他具体尺寸 */
}
.total-card {
  width: 100vw;
  height: 100vh;
  overflow: hidden;
  display: flex
}

.left-card {
  flex: 3;
  width: 75%;
  background-color: yellow;
}
.right-card{
  flex: 1;
  width: 25%;
  z-index: 1;
  background-color: white;
}

</style>