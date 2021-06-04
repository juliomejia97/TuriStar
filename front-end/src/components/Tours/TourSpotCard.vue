<template>
  <div class="slideshow-container">
    <div class="mySlides fade">
      <img
        :src="photo"
      />
      <div class="container">
        <h3>{{title}}</h3>
        <p>{{description}}</p>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
      title: String,
      description: String,
      photo: String,
  },
};
</script>

<style  lang="scss">
.slideshow-container {
  width: 30%;
  margin: 1rem;
}
.mySlides {
  position: relative;
  text-align: center;
  width: 100%;
  img {
    width: 100%;
    margin: 0;
  }
  p {
    word-wrap: break-word;
  }
  .container {
    color: #000;
    font-size: 15px;
    width: 100%;
    position: absolute;
    background-color: rgba(255, 255, 255, 0.5);
    bottom: 0rem;
    border-bottom-left-radius: 35px;
    border-bottom-right-radius: 35px;
  }
}

/* Fading animation */
.fade {
  -webkit-animation-name: fade;
  -webkit-animation-duration: 1.5s;
  animation-name: fade;
  animation-duration: 1.5s;
}

@-webkit-keyframes fade {
  from {
    opacity: 0.4;
  }
  to {
    opacity: 1;
  }
}

@keyframes fade {
  from {
    opacity: 0.4;
  }
  to {
    opacity: 1;
  }
}
</style>