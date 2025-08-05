
import React, { Component } from 'react';

class Posts extends Component {
    constructor(props) {
        super(props);
        this.state = {
            posts: []
        };
        console.log('Posts component constructor called.');
    }


    async loadPosts() {
        try {
            const response = await fetch('https://jsonplaceholder.typicode.com/posts');
            if (!response.ok) {
                throw new Error(`HTTP error! status: ${response.status}`);
            }
            const data = await response.json();
            this.setState({ posts: data });
            console.log('Posts loaded successfully.');
        } catch (error) {
            console.error("Could not fetch posts:", error);
            throw error;
        }
    }

    componentDidMount() {
        console.log('Posts component did mount. Loading posts...');
        this.loadPosts();
    }

    componentDidCatch(error, info) {
        console.error("Error caught in Posts component:", error, info);
        alert(`An error occurred in the Posts component: ${error.toString()}`);
    }

    render() {
        console.log('Posts component rendering...');
        const { posts } = this.state;

        return (
            <div>
                <h1>All Posts </h1>
                {posts.map(post => (
                    <div key={post.id} style={{ borderBottom: '1px solid #ccc', marginBottom: '20px', paddingBottom: '10px' }}>
                        <h2>{post.title}</h2>
                        <p>{post.body}</p>
                    </div>
                ))}
            </div>
        );
    }
}

export default Posts;