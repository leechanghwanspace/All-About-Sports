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

  function openInstagram() {
    var instagramProfileLink = "https://www.instagram.com/leechanghwanspace";
    window.open(instagramProfileLink, "_blank");
  }
