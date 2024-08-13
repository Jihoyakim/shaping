<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- 이 부분은 'content' 부분만 포함 -->
<div class="content">
    <h4>Manage Users</h4>
    <div class="section-content">
        <table class="table">
            <thead>
            <tr>
                <th>ID</th>
                <th>Username</th>
                <th>Email</th>
                <th>Role</th>
                <th>Actions</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>1</td>
                <td>john_doe</td>
                <td>john@example.com</td>
                <td>USER</td>
                <td><a href="/admin/users/edit/1">Edit</a> | <a href="/admin/users/delete/1">Delete</a></td>
            </tr>
            <tr>
                <td>2</td>
                <td>jane_smith</td>
                <td>jane@example.com</td>
                <td>ADMIN</td>
                <td><a href="/admin/users/edit/2">Edit</a> | <a href="/admin/users/delete/2">Delete</a></td>
            </tr>
            <!-- 추가 사용자 항목들 -->
            </tbody>
        </table>
    </div>
</div>