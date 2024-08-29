  function changeCategory(category, newText) {
  var categoryBox = document.getElementById(category);
  var spanElement = categoryBox.getElementsByTagName("span")[0];
  if (!spanElement.getAttribute('data-original-text')) {
      spanElement.setAttribute('data-original-text', spanElement.innerText);
  }
  spanElement.innerText = newText;
  }

  function resetCategory(category) {
     var categoryBox = document.getElementById(category);
     var spanElement = categoryBox.getElementsByTagName("span")[0];
     var originalText = spanElement.getAttribute('data-original-text');
     if (originalText) {
         spanElement.innerText = originalText;
     }
  }

  // ChangHwan Lee 텍스트를 클릭했을 때 새 창으로 인스타그램 프로필 링크를 엽니다.
  function openInstagram() {
    // 인스타그램 프로필 링크
    var instagramProfileLink = "https://www.instagram.com/leechanghwanspace";
    // 새 창에서 인스타그램 프로필 링크 열기
    window.open(instagramProfileLink, "_blank");
  }
