package com.google.android.gms.b;

import com.google.android.gms.ads.internal.f;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

@fd
public final class ak {
    public static final ab<Boolean> A = ab.a(0, "gads:looper_for_gms_client:enabled", Boolean.valueOf(true));
    public static final ab<Boolean> B = ab.a(0, "gads:sw_ad_request_service:enabled", Boolean.valueOf(true));
    public static final ab<Boolean> C = ab.a(0, "gads:sw_dynamite:enabled", Boolean.valueOf(true));
    public static final ab<String> D = ab.a(0, "gad:mraid:url_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_banner.js");
    public static final ab<String> E = ab.a(0, "gad:mraid:url_expanded_banner", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_expanded_banner.js");
    public static final ab<String> F = ab.a(0, "gad:mraid:url_interstitial", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/mraid/v2/mraid_app_interstitial.js");
    public static final ab<Boolean> G = ab.a(0, "gads:enabled_sdk_csi", Boolean.valueOf(false));
    public static final ab<String> H = ab.a(0, "gads:sdk_csi_server", "https://csi.gstatic.com/csi");
    public static final ab<Boolean> I = ab.a(0, "gads:sdk_csi_write_to_file", Boolean.valueOf(false));
    public static final ab<Boolean> J = ab.a(0, "gads:enable_content_fetching", Boolean.valueOf(true));
    public static final ab<Integer> K = ab.a(0, "gads:content_length_weight", 1);
    public static final ab<Integer> L = ab.a(0, "gads:content_age_weight", 1);
    public static final ab<Integer> M = ab.a(0, "gads:min_content_len", 11);
    public static final ab<Integer> N = ab.a(0, "gads:fingerprint_number", 10);
    public static final ab<Integer> O = ab.a(0, "gads:sleep_sec", 10);
    public static final ab<Boolean> P = ab.a(0, "gad:app_index_enabled", Boolean.valueOf(true));
    public static final ab<Boolean> Q = ab.a(0, "gads:app_index:without_content_info_present:enabled", Boolean.valueOf(true));
    public static final ab<Long> R = ab.a("gads:app_index:timeout_ms", 1000);
    public static final ab<String> S = ab.a(0, "gads:app_index:experiment_id");
    public static final ab<String> T = ab.a(0, "gads:kitkat_interstitial_workaround:experiment_id");
    public static final ab<Boolean> U = ab.a(0, "gads:kitkat_interstitial_workaround:enabled", Boolean.valueOf(true));
    public static final ab<Boolean> V = ab.a(0, "gads:interstitial_follow_url", Boolean.valueOf(true));
    public static final ab<Boolean> W = ab.a(0, "gads:interstitial_follow_url:register_click", Boolean.valueOf(true));
    public static final ab<String> X = ab.a(0, "gads:interstitial_follow_url:experiment_id");
    public static final ab<Boolean> Y = ab.a(0, "gads:analytics_enabled", Boolean.valueOf(true));
    public static final ab<Boolean> Z = ab.a(0, "gads:ad_key_enabled", Boolean.valueOf(false));
    public static final ab<String> a = ab.a(0, "gads:sdk_core_experiment_id");
    public static final ab<Boolean> aA = ab.a(0, "gass:enabled", Boolean.valueOf(false));
    public static final ab<Boolean> aB = ab.a(0, "gass:enable_int_signal", Boolean.valueOf(true));
    public static final ab<Boolean> aC = ab.a(0, "gads:adid_notification:first_party_check:enabled", Boolean.valueOf(true));
    public static final ab<Boolean> aD = ab.a(0, "gads:edu_device_helper:enabled", Boolean.valueOf(true));
    public static final ab<Boolean> aE = ab.a(0, "gads:support_screen_shot", Boolean.valueOf(true));
    public static final ab<Long> aF = ab.a("gads:js_flags:update_interval", TimeUnit.HOURS.toMillis(12));
    public static final ab<Boolean> aG = ab.a(0, "gads:custom_render:ping_on_ad_rendered", Boolean.valueOf(false));
    public static final ab<Integer> aa = ab.a(0, "gads:webview_cache_version", 0);
    public static final ab<String> ab = ab.a("gads:pan:experiment_id");
    public static final ab<String> ac = ab.a(0, "gads:native:engine_url", "//googleads.g.doubleclick.net/mads/static/mad/sdk/native/native_ads.html");
    public static final ab<Boolean> ad = ab.a(0, "gads:ad_manager_creator:enabled", Boolean.valueOf(true));
    public static final ab<Boolean> ae = ab.a(1, "gads:interstitial_ad_pool:enabled", Boolean.valueOf(false));
    public static final ab<String> af = ab.a(1, "gads:interstitial_ad_pool:schema", "customTargeting");
    public static final ab<Integer> ag = ab.a(1, "gads:interstitial_ad_pool:max_pools", 3);
    public static final ab<Integer> ah = ab.a(1, "gads:interstitial_ad_pool:max_pool_depth", 2);
    public static final ab<Integer> ai = ab.a(1, "gads:interstitial_ad_pool:time_limit_sec", 1200);
    public static final ab<String> aj = ab.a(1, "gads:interstitial_ad_pool:experiment_id");
    public static final ab<Boolean> ak = ab.a(0, "gads:log:verbose_enabled", Boolean.valueOf(false));
    public static final ab<Boolean> al = ab.a(0, "gads:device_info_caching:enabled", Boolean.valueOf(true));
    public static final ab<Long> am = ab.a("gads:device_info_caching_expiry_ms:expiry", 300000);
    public static final ab<Boolean> an = ab.a(0, "gads:gen204_signals:enabled", Boolean.valueOf(false));
    public static final ab<Boolean> ao = ab.a(0, "gads:webview:error_reporting_enabled", Boolean.valueOf(false));
    public static final ab<Boolean> ap = ab.a(0, "gads:adid_reporting:enabled", Boolean.valueOf(false));
    public static final ab<Boolean> aq = ab.a(0, "gads:ad_settings_page_reporting:enabled", Boolean.valueOf(false));
    public static final ab<Boolean> ar = ab.a(0, "gads:adid_info_gmscore_upgrade_reporting:enabled", Boolean.valueOf(false));
    public static final ab<Boolean> as = ab.a(0, "gads:request_pkg:enabled", Boolean.valueOf(true));
    public static final ab<Boolean> at = ab.a(0, "gads:gmsg:disable_back_button:enabled", Boolean.valueOf(false));
    public static final ab<Long> au = ab.a("gads:network:cache_prediction_duration_s", 300);
    public static final ab<Boolean> av = ab.a(0, "gads:mediation:dynamite_first:admobadapter", Boolean.valueOf(true));
    public static final ab<Boolean> aw = ab.a(0, "gads:mediation:dynamite_first:adurladapter", Boolean.valueOf(true));
    public static final ab<Long> ax = ab.a("gads:ad_loader:timeout_ms", 60000);
    public static final ab<Long> ay = ab.a("gads:rendering:timeout_ms", 60000);
    public static final ab<Boolean> az = ab.a(0, "gads:adshield:enable_adshield_instrumentation", Boolean.valueOf(false));
    public static final ab<String> b = ab.a(0, "gads:sdk_core_location", "https://googleads.g.doubleclick.net/mads/static/mad/sdk/native/sdk-core-v40.html");
    public static final ab<Boolean> c = ab.a(0, "gads:request_builder:singleton_webview", Boolean.valueOf(false));
    public static final ab<String> d = ab.a(0, "gads:request_builder:singleton_webview_experiment_id");
    public static final ab<Boolean> e = ab.a(0, "gads:sdk_use_dynamic_module", Boolean.valueOf(false));
    public static final ab<String> f = ab.a(0, "gads:sdk_use_dynamic_module_experiment_id");
    public static final ab<Boolean> g = ab.a(0, "gads:sdk_crash_report_enabled", Boolean.valueOf(false));
    public static final ab<Boolean> h = ab.a(0, "gads:sdk_crash_report_full_stacktrace", Boolean.valueOf(false));
    public static final ab<Boolean> i = ab.a(0, "gads:block_autoclicks", Boolean.valueOf(false));
    public static final ab<String> j = ab.a(0, "gads:block_autoclicks_experiment_id");
    public static final ab<String> k = ab.a("gads:prefetch:experiment_id");
    public static final ab<String> l = ab.a(0, "gads:spam_app_context:experiment_id");
    public static final ab<Boolean> m = ab.a(0, "gads:spam_app_context:enabled", Boolean.valueOf(false));
    public static final ab<String> n = ab.a(0, "gads:video_stream_cache:experiment_id");
    public static final ab<Integer> o = ab.a(0, "gads:video_stream_cache:limit_count", 5);
    public static final ab<Integer> p = ab.a(0, "gads:video_stream_cache:limit_space", 8388608);
    public static final ab<Integer> q = ab.a(0, "gads:video_stream_exo_cache:buffer_size", 8388608);
    public static final ab<Long> r = ab.a("gads:video_stream_cache:limit_time_sec", 300);
    public static final ab<Long> s = ab.a("gads:video_stream_cache:notify_interval_millis", 1000);
    public static final ab<Integer> t = ab.a(0, "gads:video_stream_cache:connect_timeout_millis", 10000);
    public static final ab<Boolean> u = ab.a(0, "gads:video:metric_reporting_enabled", Boolean.valueOf(false));
    public static final ab<String> v = ab.a(0, "gads:video:metric_frame_hash_times", "");
    public static final ab<Long> w = ab.a("gads:video:metric_frame_hash_time_leniency", 500);
    public static final ab<String> x = ab.a("gads:spam_ad_id_decorator:experiment_id");
    public static final ab<Boolean> y = ab.a(0, "gads:spam_ad_id_decorator:enabled", Boolean.valueOf(false));
    public static final ab<String> z = ab.a("gads:looper_for_gms_client:experiment_id");

    public static List<String> a() {
        ag h = f.h();
        List<String> arrayList = new ArrayList();
        for (ab a : h.b) {
            String str = (String) f.i().a(a);
            if (str != null) {
                arrayList.add(str);
            }
        }
        return arrayList;
    }
}
