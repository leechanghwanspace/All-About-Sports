 // ChangHwan Lee 텍스트를 클릭했을 때 새 창으로 인스타그램 프로필 링크를 엽니다.
  function openInstagram() {
    // 인스타그램 프로필 링크
    var instagramProfileLink = "https://www.instagram.com/leechanghwanspace";
    // 새 창에서 인스타그램 프로필 링크 열기
    window.open(instagramProfileLink, "_blank");
  }

  // "WATCH MORE" 버튼 클릭 시 category.html로 이동
  const watchMoreButton = document.getElementById('watch-more');

  watchMoreButton.addEventListener('mouseover', function() {
   watchMoreButton.textContent = '더 보기';
  });

  watchMoreButton.addEventListener('mouseout', function() {
   watchMoreButton.textContent = 'WATCH MORE';
  });

  document.getElementById("watch-more").addEventListener("click", function() {
    window.location.href = "category";
  });

   // 타이핑할 문구
  const text = "ALL about SPORTS";
  // 타이핑 속도 (ms 단위)
  const typingSpeed = 200;

  // 타이핑되는 텍스트를 담을 변수
  let index = 0;

  // 타이핑 효과를 구현하는 함수
  function type() {
    // 문자 하나씩 가져와서 출력
    document.querySelector('.hero h2').textContent += text[index];
    // 다음 문자로 이동
    index++;
    // 모든 문자를 출력한 경우 index 초기화
    if (index >= text.length) {
      index = 0;
      clearInterval(typingInterval);
    }
  }

  // 일정한 간격으로 type 함수를 호출하여 타이핑 효과 구현
  const typingInterval = setInterval(type, typingSpeed);

  const heroText = document.getElementById('hero-text');

  heroText.addEventListener('mouseover', function() {
    heroText.innerHTML = '<br>아스,<br>"올 어바웃 스포츠는 함께하는 운동을 지향합니다."<br><br>';
    heroText.style.color = '#1fdfdf';
  });
  heroText.addEventListener('mouseout', function() {
      heroText.innerHTML = '<br>AaS,<br>"all about sports is aim for exercise together."<br> <br>';
      heroText.style.color = 'white';
  });




  const coopCompText = document.getElementById('coop-comp-text');

  coopCompText.addEventListener('mouseover', function() {
    coopCompText.innerHTML = '협력과 경쟁,<br>"스포츠에서의 협력과 경쟁의 기능"';
    coopCompText.style.color = '#1fdfdf';
 });

  coopCompText.addEventListener('mouseout', function() {
    coopCompText.innerHTML = 'Cooperation and Competition,<br>"the function of cooperation and competition in sports"';
    coopCompText.style.color = 'white';
  });


  const coopCompButton = document.getElementById('coop-comp-button');

coopCompButton.addEventListener('mouseover', function() {
  coopCompButton.innerHTML = 'WATCH MORE 버튼을 누르세요.';
  coopCompButton.style.color = '#1fdfdf'; // 텍스트 색상 변경
});

coopCompButton.addEventListener('mouseout', function() {
  coopCompButton.innerHTML = 'Press the WATCH MORE button.<br>';
  coopCompButton.style.color = 'white'; // 텍스트 색상 변경
});

document.addEventListener("DOMContentLoaded", function () {
  const prevButton = document.querySelector(".prev-button");
  const nextButton = document.querySelector(".next-button");
  const images = document.querySelectorAll(".image-slider img");
  const circles = document.querySelectorAll(".circle");
  let currentIndex = 0;

  // 이미지 초기화
  function showImage(index) {
    images.forEach((img, idx) => {
      img.style.display = (idx === index) ? "block" : "none";
    });
    circles.forEach((circle, idx) => {
      circle.classList.toggle("active-circle", idx === index);
    });
  }

  // 다음 이미지 표시
  function nextImage() {
    currentIndex = (currentIndex + 1) % images.length;
    showImage(currentIndex);
  }

  // 이전 이미지 표시
  function prevImage() {
    currentIndex = (currentIndex - 1 + images.length) % images.length;
    showImage(currentIndex);
  }

  // 초기 이미지 표시
  showImage(currentIndex);

  // 다음 버튼 클릭 시
  nextButton.addEventListener("click", nextImage);

  // 이전 버튼 클릭 시
  prevButton.addEventListener("click", prevImage);

  // 동그라미 클릭 시 해당 이미지 표시
  circles.forEach((circle, index) => {
    circle.addEventListener("click", function () {
      currentIndex = index;
      showImage(currentIndex);
    });
  });

  // 자동 슬라이드 기능 추가
  let interval = setInterval(nextImage, 2000); // 2초마다 이미지 변경

  // 슬라이드 멈추기 및 다시 시작
  function stopInterval() {
    clearInterval(interval);
  }

  function startInterval() {
    interval = setInterval(nextImage, 2000);
  }

  prevButton.addEventListener("mouseover", stopInterval);
  prevButton.addEventListener("mouseout", startInterval);
  nextButton.addEventListener("mouseover", stopInterval);
  nextButton.addEventListener("mouseout", startInterval);
  circles.forEach(circle => {
    circle.addEventListener("mouseover", stopInterval);
    circle.addEventListener("mouseout", startInterval);
  });
});


const section3Text = document.getElementById('section3-text');

section3Text.addEventListener('mouseover', function() {
  section3Text.textContent = "현대인들이 가장 접근하기 쉽고 가장 인기있는 스포츠 종목 상위 5개를 선정했습니다.";
  section3Text.style.color = '#1fdfdf'; // 텍스트 색상 변경
});

section3Text.addEventListener('mouseout', function() {
  section3Text.textContent = "Selected the top 5 most accessible and most famous sports events for modern people.";
  section3Text.style.color = 'white'; // 텍스트 색상 변경
});

const boxes = document.querySelectorAll('.box');

boxes.forEach(box => {
box.addEventListener('mouseover', function() {
  const altText = box.querySelector('img').alt.toUpperCase();
  const additionalText = document.querySelector('.additional-text');
  additionalText.textContent = altText;
  additionalText.style.display = 'block';
});

box.addEventListener('mouseout', function() {
  const additionalText = document.querySelector('.additional-text');
  additionalText.style.display = 'none';
});
});

