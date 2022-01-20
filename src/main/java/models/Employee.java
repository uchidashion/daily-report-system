package models;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import constants.JpaConst;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 従業員データのDTOモデル
 *
 */

@Table(name = JpaConst.TABLE_EMP)
@NamedQueries({
    @NamedQuery(  //全ての従業員のidを降順に取得
        name = JpaConst.Q_EMP_GET_ALL,
        query = JpaConst.Q_EMP_GET_ALL_DEF),
    @NamedQuery(  //全ての従業員の件数を取得
        name = JpaConst.Q_EMP_COUNT,
        query = JpaConst.Q_EMP_COUNT_DEF),
    @NamedQuery(  //指定した社員番号を保持する従業員の件数を取得する
        name = JpaConst.Q_EMP_COUNT_RESISTERED_BY_CODE,
        query = JpaConst.Q_EMP_COUNT_RESISTERED_BY_CODE_DEF),
    @NamedQuery(  //社員番号とハッシュ化済パスワードを条件に未削除の従業員を取得する
        name = JpaConst.Q_EMP_GET_BY_CODE_AND_PASS,
        query = JpaConst.Q_EMP_GET_BY_CODE_AND_PASS_DEF)
})

@Getter  //全てのクラスフィールドについてgetterを自動生成する（Lombok）
@Setter   //全てのクラスフィールドについてsetterを自動生成する（Lombok）
@NoArgsConstructor  //引数なしコンストラクタを自動生成する(Lombok)
@AllArgsConstructor  //全てのクラスフィールドに引数に持つ引数ありコンストラクタを自動生成する(Lombok)
@Entity

public class Employee {

    /**
     * id
     */

    @Id
    @Column(name = JpaConst.EMP_COL_ID)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 社員番号
     */
    @Column(name = JpaConst.EMP_COL_CODE, nullable = false, unique = true)
    private String code;

    /**
     * パスワード
     */
    @Column(name = JpaConst.EMP_COL_NAME, length = 64, nullable = false)
    private String password;

    /**
     * 氏名
     */
    @Column(name = JpaConst.EMP_COL_NAME, nullable = false)
    private String name;

    /**
     * 管理権限があるかどうか(一般：０、管理者：１)
     */
    @Column(name = JpaConst.EMP_COL_ADMIN_FLAG, nullable = false)
    private Integer adminFlag;

    /**
     * 登録日時
     */
    @Column(name = JpaConst.EMP_COL_CREATED_AT, nullable = false)
    private LocalDateTime createdAt;

    /**
     * 更新日時
     */
    @Column(name = JpaConst.EMP_COL_UPDATED_AT, nullable = false)
    private LocalDateTime updatedAt;

    /**
     * 削除されたかどうか（現役：０、削除済み：１）
     */
    @Column(name = JpaConst.EMP_COL_DELETE_FLAG, nullable = false)
    private Integer deleteFlag;
}
