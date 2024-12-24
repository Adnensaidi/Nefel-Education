var video = document.querySelector("video")

function playVideo() {
    video.play();
    video.muted = false;
}

function pauseVideo() {
    video.pause();
    video.currentTime = 0;
}