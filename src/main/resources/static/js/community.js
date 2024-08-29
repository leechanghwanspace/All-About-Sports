  function openInstagram() {
    var instagramProfileLink = "https://www.instagram.com/leechanghwanspace";
    window.open(instagramProfileLink, "_blank");
  }


  function togglePostForm() {
      const popup = document.getElementById('popup');
      popup.style.display = (popup.style.display === 'block') ? 'none' : 'block';
  }

  const posts = Array.from(document.querySelectorAll('.post-item')).reverse();
  const pagination = document.getElementById('pagination');
  const postsPerPage = 4;
  let currentPage = 1;

  function displayPosts(page) {
      const start = (page - 1) * postsPerPage;
      const end = start + postsPerPage;
      posts.forEach((post, index) => {
          post.style.display = 'none';
      });

      const currentPosts = posts.slice(start, end);
      currentPosts.forEach(post => {
          post.style.display = 'block';
      });

      const postContainer = document.getElementById('post-items');
      postContainer.innerHTML = '';
      currentPosts.forEach(post => {
          postContainer.appendChild(post);
      });
  }

  function setupPagination() {
      const pageCount = Math.ceil(posts.length / postsPerPage);
      pagination.innerHTML = '';
      for (let i = 1; i <= pageCount; i++) {
          const pageBtn = document.createElement('button');
          pageBtn.innerText = i;
          pageBtn.onclick = () => {
              currentPage = i;
              displayPosts(i);
          };
          pagination.appendChild(pageBtn);
      }
  }

  displayPosts(currentPage);
  setupPagination();
