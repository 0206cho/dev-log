package com.project.boardserver.service.impl;

import com.project.boardserver.dto.CommentDTO;
import com.project.boardserver.dto.PostDTO;
import com.project.boardserver.dto.TagDTO;
import com.project.boardserver.dto.UserDTO;
import com.project.boardserver.mapper.CommentMapper;
import com.project.boardserver.mapper.PostMapper;
import com.project.boardserver.mapper.TagMapper;
import com.project.boardserver.mapper.UserProfileMapper;
import com.project.boardserver.service.PostService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * description    :
 * packageName    : com.project.boardserver.service.impl
 * fileName        : PostServiceImpl
 * author         : kimminsol
 * date           : 2026. 6. 3.
 * ===========================================================
 * DATE              AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2026. 6. 3.        kimminsol       최초 생성
 */
@Service
@Log4j2
public class PostServiceImpl implements PostService {

    @Autowired
    private PostMapper postMapper;

    @Autowired
    private UserProfileMapper userProfileMapper;

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private TagMapper tagMapper;

    /**
     * 게시글 등록
     * @param id
     * @param postDTO
     */
    @Override
    public void register(String id, PostDTO postDTO) {
        UserDTO userInfo = userProfileMapper.getUserProfile(id);

        postDTO.setUserId(userInfo.getId());
        postDTO.setCreateTime(new Date());
        postDTO.setUpdateTime(new Date());

        if(userInfo != null){
            postMapper.register(postDTO);

            Integer postId = postDTO.getId();
            for(int i=0; i<postDTO.getTagDTOList().size(); i++){
                TagDTO tagDTO = postDTO.getTagDTOList().get(i);
                tagMapper.register(tagDTO);

                Integer tagId = tagDTO.getId();
                tagMapper.createPostTag(tagId, postId);
            }
        } else {
            log.error("register post ERROR! {}", postDTO);
            throw new RuntimeException("register post ERROR! 게시글 등록 메서드를 확인해주세요" + postDTO);
        }
    }

    /**
     * 게시글 조회 - 본인 작성글
     * @param accountId
     * @return
     */
    @Override
    public List<PostDTO> getMyPosts(int accountId) {
        return postMapper.selectMyPosts(accountId);
    }

    /**
     * 게시글 수정
     * @param postDTO
     */
    @Override
    public void updatePosts(PostDTO postDTO) {
        if(postDTO != null && postDTO.getId() !=0){
            postMapper.update(postDTO);
        } else {
            log.error("update post ERROR! {}", postDTO);
            throw new RuntimeException("update post ERROR! 게시글 수정 메서드를 확인해주세요" + postDTO);
        }
    }

    /**
     * 게시글 삭제
     * @param userId
     * @param postId
     */
    @Override
    public void deletePosts(int userId, int postId) {
        if(userId != 0 && postId != 0){
            postMapper.delete(postId);
        } else {
            log.error("delete post ERROR! {}", postId);
            throw new RuntimeException("delete post ERROR! 게시글 삭제 메서드를 확인해주세요" + postId);
        }

    }

    /**
     * 댓글 등록
     * @param commentDTO
     */
    @Override
    public void registerComment(CommentDTO commentDTO) {
        if(commentDTO.getPostId() != 0){
            commentMapper.register(commentDTO);
        } else {
            log.error("registerComment ERROR! {}", commentDTO);
            throw new RuntimeException("registerComment " + commentDTO);
        }
    }

    /**
     * 댓글 수정
     * @param commentDTO
     */
    @Override
    public void updateComment(CommentDTO commentDTO) {
        if(commentDTO != null){
            commentMapper.update(commentDTO);
        } else {
            log.error("updateComment ERROR!");
            throw new RuntimeException("updateComment ");
        }
    }

    /**
     * 댓글 삭제
     * @param userId
     * @param commentId
     */
    @Override
    public void deleteComment(int userId, int commentId) {
        if(userId != 0 && commentId != 0){
            commentMapper.delete(commentId);
        } else {
            log.error("deleteComment ERROR! {}", commentId);
            throw new RuntimeException("deleteComment " + commentId);
        }
    }

    /**
     * 태그 저장
     * @param tagDTO
     */
    @Override
    public void registerTag(TagDTO tagDTO) {
        if(tagDTO != null){
            tagMapper.register(tagDTO);
        } else {
            log.error("registerTag ERROR!");
            throw new RuntimeException("registerTag ");
        }
    }

    /**
     * 태그 수정
     * @param tagDTO
     */
    @Override
    public void updateTag(TagDTO tagDTO) {
        if(tagDTO != null){
            tagMapper.update(tagDTO);
        } else {
            log.error("updateTag ERROR!");
            throw new RuntimeException("updateTag ");
        }
    }

    /**
     * 태그 삭제
     * @param userId
     * @param tagId
     */
    @Override
    public void deleteTag(int userId, int tagId) {
        if(userId != 0 && tagId != 0){
            tagMapper.delete(tagId);
        } else {
            log.error("deleteTag ERROR! {}", tagId);
            throw new RuntimeException("deleteTag " + tagId);
        }
    }
}
