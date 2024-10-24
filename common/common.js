const URL = "https://community-support-project.onrender.com";
// const URL = "http://localhost:8080";

// =============== USER ====================
export const getUsers = URL + "/api/users"; // Get all users
export const getUser = URL + "/api/users"; // Get a user
export const postUser = URL + "/api/users"; // Post a user     => Register user

// ================== ORG ==================
export const postORG = URL + "/api/organization"; // Post a organization     => Register organization

// =============== AUTH ====================
export const login = URL + "/api/auth/login"; // Login

// =================== URL index =======================
export const URLIndex = "./index.html";
