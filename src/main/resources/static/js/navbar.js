document.addEventListener('DOMContentLoaded', function() {
    const homeLink = document.getElementById('home');
    const listLink = document.getElementById('list');
    const boardLink = document.getElementById('board');
    const loginLink = document.getElementById('login');
    const signupLink = document.getElementById('signup');
    const mypageLink = document.getElementById('mypage');
    const logoutLink = document.getElementById('logout-link');

    if (homeLink) {
        homeLink.addEventListener('mouseover', function() {
            homeLink.textContent = '홈으로';
        });
        homeLink.addEventListener('mouseout', function() {
            homeLink.textContent = 'HOME';
        });
    }

    if (listLink) {
        listLink.addEventListener('mouseover', function() {
            listLink.textContent = '목 록';
        });
        listLink.addEventListener('mouseout', function() {
            listLink.textContent = 'LIST';
        });
    }

    if (boardLink) {
        boardLink.addEventListener('mouseover', function() {
            boardLink.textContent = '게시판';
        });
        boardLink.addEventListener('mouseout', function() {
            boardLink.textContent = 'BOARD';
        });
    }

    if (loginLink) {
        loginLink.addEventListener('mouseover', function() {
            loginLink.textContent = '로그인';
        });
        loginLink.addEventListener('mouseout', function() {
            loginLink.textContent = 'LOGIN';
        });
    }

    if (signupLink) {
        signupLink.addEventListener('mouseover', function() {
            signupLink.textContent = '회원가입';
        });
        signupLink.addEventListener('mouseout', function() {
            signupLink.textContent = 'SIGN UP';
        });
    }

    if (mypageLink) {
        mypageLink.addEventListener('mouseover', function() {
            mypageLink.textContent = '마이페이지';
        });
        mypageLink.addEventListener('mouseout', function() {
            mypageLink.textContent = 'MY PAGE';
        });
    }

    if (logoutLink) {
        logoutLink.addEventListener('mouseover', function() {
            logoutLink.textContent = '로그아웃';
        });
        logoutLink.addEventListener('mouseout', function() {
            logoutLink.textContent = 'LOGOUT';
        });
    }
});
