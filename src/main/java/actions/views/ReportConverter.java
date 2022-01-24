package actions.views;

import java.util.ArrayList;
import java.util.List;

import models.Report;

/**
 * 日報データのDTOモデル↔︎Viewモデルの変換を行うクラス
 *
 */
public class ReportConverter {

    /**
     * ViewモデルのインスタンスからDTOモデルのインスタンスを作成する
     * @param rv ReportViewのインスタンス
     * @return Reportのインスタンス
     */
    public static Report toModel(ReportView rv) {
        //ReportViewのインスタンスをDTOモデルのインスタンスに変換する
        return new Report(
                rv.getId(),
                EmployeeConverter.toModel(rv.getEmployee()),
                rv.getReportDate(),
                rv.getTitle(),
                rv.getContent(),
                rv.getCreatedAt(),
                rv.getUpdatedAt());
    }

    /**
     * DTOモデルのインスタンスからViewモデルのインスタンスを作成する
     * @param r Reportのインスタンス
     * @return ReportViewのインスタンス
     */
    public static ReportView toView(Report r) {
        //DTOクラスのインスタンスが空ならnullを返す
        if(r == null) {
            return null;
        }
        //DTOクラスのインスタンスがある場合はReportViewのインスタンスに変換する
        return new ReportView(
                r.getId(),
                EmployeeConverter.toView(r.getEmployee()),
                r.getReportDate(),
                r.getTitle(),
                r.getContent(),
                r.getCreatedAt(),
                r.getUpdatedAt());
    }

    /**
     * DTOモデルのリストからViewモデルのリストを作成する
     * @param list DTOモデルのリスト
     * @return Viewモデルのリスト
     */
    public static List<ReportView> toViewList(List<Report> list){
        List<ReportView> evs = new ArrayList<>();

        for(Report r : list) {
            //DTOクラスのインスタンスをリストに追加
            evs.add(toView(r));
        }
        return evs;
    }

    /**
     * Viewモデルの全フィールドの内容をDTOモデルのフィールドにコピーする
     * @param r DTOモデル（コピー先）
     * @param rv Viewモデル（コピー元）
     */
    public static void copyViewToModel(Report r, ReportView rv) {
        r.setId(rv.getId());
        r.setEmployee(EmployeeConverter.toModel(rv.getEmployee()));
        r.setReportDate(rv.getReportDate());
        r.setTitle(rv.getTitle());
        r.setContent(rv.getContent());
        r.setCreatedAt(rv.getCreatedAt());
        r.setUpdatedAt(rv.getUpdatedAt());
    }
}
