  function changeCategory(category, newText) {
      var categoryBox = document.getElementById(category);
      categoryBox.getElementsByTagName("span")[0].innerText = newText;
  }

  function resetCategory(category, originalText) {
      var categoryBox = document.getElementById(category);
      categoryBox.getElementsByTagName("span")[0].innerText = originalText;
  }

  function openInstagram() {
    var instagramProfileLink = "https://www.instagram.com/leechanghwanspace";
    window.open(instagramProfileLink, "_blank");
  }
