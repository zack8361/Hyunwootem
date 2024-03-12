package com.hyunwootem.hyunwootemproject.entity;


import jakarta.persistence.*;
import lombok.*;


import static jakarta.persistence.FetchType.*;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;
import static lombok.AccessLevel.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = PROTECTED)
@ToString(of = {"title","content"})
public class Notice extends NoticeAuditing{

    @Id @GeneratedValue
    @Column(name = "notice_id")
    private Long id;
    private String title;
    private String content;


    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void setMember(Member member){
        this.member = member;
        member.getNotices().add(this);
    }
    private Notice(String title, String content, Member member) {
        this.title = title;
        this.content = content;
        setMember(member);
    }

    //== 공지 생성 메서드 ==//
    public static Notice createNotice(String title, String content, Member member){
        requireNonNull(title);
        requireNonNull(content);
        requireNonNull(member);
        return new Notice(title,content,member);
    }
}
