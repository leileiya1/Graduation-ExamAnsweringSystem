<script setup>
// 在你的Vue组件中
import { Swiper, SwiperSlide } from 'swiper/vue';
import 'swiper/css'; // 核心样式
import 'swiper/css/pagination'; // 分页样式
import 'swiper/css/navigation';
import {Autoplay, Navigation, Pagination} from "swiper/modules"; // 导航样式

</script>

<template>
  <div class="swiper-container">
    <Swiper
        :modules="[Pagination, Navigation,Autoplay]"
        :loop="true"
        :autoplay="{ delay: 2500, disableOnInteraction: false }"
        :pagination="{ clickable: true }"
        :navigation="true"
        class="mySwiper"
    >
      <SwiperSlide><a href=""><img src="/image/1.jpg" alt="Image 1" /></a></SwiperSlide>
      <SwiperSlide><a href=""><img src="/image/2.jpg" alt="Image 2" /></a></SwiperSlide>
      <SwiperSlide><a href=""><img src="/image/3.jpg" alt="Image 3" /></a></SwiperSlide>
      <SwiperSlide><a href=""><img src="/image/1.jpg" alt="Image 4" /></a></SwiperSlide>
      <SwiperSlide><a href=""><img src="/image/2.jpg" alt="Image 5" /></a></SwiperSlide>
    </Swiper>
  </div>
</template>

<style scoped>
/* 设置Swiper容器的大小 */
.swiper-container {
  width: 100%; /* 组件宽度 */
  height: 100%; /* 组件高度 */
}

/* 设置图片填充Swiper Slide */
.slide-image {
  width: 100%;
  height: 100%;
  object-fit: cover; /* 保持图片比例同时填充整个容器 */
}
.swiper {
  width: 100%;
  height: 100vh; /* 或者根据需要设置固定高度 */
}

.swiper-slide img {
  width: 100%;
  height: 100%;
  object-fit: cover;
}
</style>